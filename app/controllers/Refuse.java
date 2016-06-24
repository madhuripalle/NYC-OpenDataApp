package controllers;

import com.socrata.api.HttpLowLevel;
import com.socrata.api.Soda2Consumer;
import com.socrata.builders.SoqlQueryBuilder;
import com.socrata.exceptions.LongRunningQueryException;
import com.socrata.exceptions.SodaError;
import com.socrata.model.soql.SoqlQuery;
import com.sun.jersey.api.client.ClientResponse;
import play.db.DB;
import play.mvc.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;


/**
 * Created by madhuripalle on 9/4/15.
 */

public class Refuse extends Controller {

    private static boolean tableCreated;

    public Refuse() {
        tableCreated = false;
    }

    private void createTable() {
        Connection connection = DB.getConnection();
        try {
            Statement stat = connection.createStatement();
            stat.execute("CREATE TABLE totalDB(b VARCHAR(255) NOT NULL, cid VARCHAR(255) NOT NULL, total INT)");
            stat.execute("ALTER TABLE totalDB ADD PRIMARY KEY (b, cid)");
            stat.close();
            connection.close();
            tableCreated = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Result connectToDB(String burough, String commID, Integer roundedtotal)
    {
        if(!tableCreated) {
            createTable();
        }

        Connection connection = DB.getConnection();
        try {
            Statement stat = connection.createStatement();
            stat.execute("merge into totalDB(b, cid, total) values('" + burough + "', '" + commID + "', '" + roundedtotal + "')");
            stat.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }


        return ok();
    }

    public ClientResponse getResponse(String burough, String commID) throws LongRunningQueryException, SodaError {

        Soda2Consumer consumer = Soda2Consumer.newConsumer("http://data.cityofnewyork.us");

        SoqlQuery getRefuse = new SoqlQueryBuilder()
                .addSelectPhrase("refusetonscollected, papertonscollected, mgptonscollected")
                .setWhereClause("month='2014 / 01' AND borough='" + burough +
                        "' AND communitydistrict='" + commID + "'")
                .build();
        return consumer.query("ebb7-mvp5",
                HttpLowLevel.JSON_TYPE,
                getRefuse);
    }

    public Integer QueryDB(String burough, String commID, Integer id) {

        String ref;
        float refnum, papnum, mgpnum;
        Integer roundedref, roundedpap, roundedmgp, roundedtotal;
        String pap;
        String mgp;
        try {

            if (commID.length()==1)
            {
                commID = "0" + commID;
            }

            if(burough != null && burough.toLowerCase().equals("statenisland")) {
                burough = "staten island";
            }

            ClientResponse response = getResponse(burough, commID);

            List<Map<String, String>> payload = response.getEntity(List.class);

            /* getting all three values for totalling and throwing in DB */
            if(payload == null || payload.size() == 0 || payload.get(0) == null || payload.get(0).size() == 0) {
                return 0;
            }
            ref = payload.get(0).get("refusetonscollected");
            pap = payload.get(0).get("papertonscollected");
            mgp = payload.get(0).get("mgptonscollected");
            refnum = Float.parseFloat(ref);
            papnum = Float.parseFloat(pap);
            mgpnum = Float.parseFloat(mgp);
            roundedref = Math.round(refnum);
            roundedmgp = Math.round(mgpnum);
            roundedpap = Math.round(papnum);

            roundedtotal = Math.round(refnum+papnum+mgpnum);

            //input query in database
            connectToDB(burough, commID, roundedtotal);

            if(id == 1)
                return roundedref;
            else if(id == 2)
                return roundedpap;
            else
                return roundedmgp;

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;

    }


    public Result refuse(String burough, String commID) {

        try {
            Integer rounded = QueryDB(burough, commID, 1);
            return ok(rounded.toString());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return ok("0");

    }

    public Result paper(String burough, String commID) {

        try {
            Integer rounded = QueryDB(burough, commID, 2);
            return ok(rounded.toString());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return ok("0");

    }

    public Result mgp(String burough, String commID) {

        try {
            Integer rounded = QueryDB(burough, commID, 3);
            return ok(rounded.toString());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return ok("0");


    }

    public Result total() {

        try {
            Integer sum = getTotal();
            return ok(sum.toString());

        } catch (SQLException e) {
            System.out.println(e);
        }

        return ok("0");
    }

    public   Integer getTotal() throws SQLException {
        if(!tableCreated) {
            createTable();
        }
        Connection connection = DB.getConnection();
        Statement stat = connection.createStatement();
        ResultSet rs = stat.executeQuery("select b, cid, sum(total) as TOTALSUM from totalDB group by (b, cid)");
        Integer result = 0;
        while(rs.next()) {
            result += rs.getInt("TOTALSUM");
        }
        stat.close();
        connection.close();
        return result;
    }
}
