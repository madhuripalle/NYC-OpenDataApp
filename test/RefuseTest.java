/**
 * Created by madhuripalle on 9/15/15.
 */

import com.sun.jersey.api.client.ClientResponse;
import controllers.Refuse;
import org.junit.Test;
import play.mvc.Results;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RefuseTest {

    @Test
    public void QueryDBTest() {

        // mock refuse class
        Refuse refuse = mock(Refuse.class);
        when(refuse.connectToDB(anyString(), anyString(), anyInt())).thenReturn(Results.ok());
        when(refuse.QueryDB(anyString(), anyString(), any())).thenCallRealMethod();

        // create testing data 1
        String burough1 = "b1";
        String commID1 = "c1";
        ClientResponse responseMock1 = mock(ClientResponse.class);
        List<Map<String, String>> payload1 = new ArrayList<Map<String, String>>();
        Map<String, String> payloadMap1 = new HashMap<String, String>();
        payloadMap1.put("refusetonscollected", "15.25");
        payloadMap1.put("papertonscollected", "20.1");
        payloadMap1.put("mgptonscollected", "30.9");
        payload1.add(payloadMap1);

        // create testing data 2
        String burough2 = "b2";
        String commID2 = "2";
        ClientResponse responseMock2 = mock(ClientResponse.class);
        List<Map<String, String>> payload2 = new ArrayList<Map<String, String>>();

        try {
            when(refuse.getResponse(burough1, commID1)).thenReturn(responseMock1);
            when(refuse.getResponse(burough2, "0" + commID2)).thenReturn(responseMock2);
            when(responseMock1.getEntity(List.class)).thenReturn(payload1);
            when(responseMock2.getEntity(List.class)).thenReturn(payload2);
        } catch (Exception e) {
            //do nothing
        }

        assertEquals(refuse.QueryDB(burough1, commID1, 1), new Integer(15));
        assertEquals(refuse.QueryDB(burough1, commID1, 2), new Integer(20));
        assertEquals(refuse.QueryDB(burough1, commID1, 3), new Integer(31));
        assertEquals(refuse.QueryDB(burough2, commID2, 1), new Integer(0));
        assertEquals(refuse.QueryDB(burough2, commID2, 2), new Integer(0));
        assertEquals(refuse.QueryDB(burough2, commID2, 3), new Integer(0));
    }

    @Test
    public void refuseTest() {

        // mock refuse class
        Refuse refuse = mock(Refuse.class);
        when(refuse.refuse(anyString(), anyString())).thenCallRealMethod();

        // create testing data 1
        String burough1 = "b1";
        String commID1 = "c1";

        // create testing data 2
        String burough2 = "b2";
        String commID2 = "c2";

        when(refuse.QueryDB(burough1, commID1, 1)).thenReturn(15);
        when(refuse.QueryDB(burough2, commID2, 1)).thenReturn(0);

        assertEquals(refuse.refuse(burough1, commID1).toString(), Results.ok("15").toString());
        assertEquals(refuse.refuse(burough2, commID2).toString(), Results.ok("0").toString());
    }

    @Test
    public void paperTest() {

        // mock refuse class
        Refuse refuse = mock(Refuse.class);
        when(refuse.paper(anyString(), anyString())).thenCallRealMethod();

        // create testing data 1
        String burough1 = "b1";
        String commID1 = "c1";

        // create testing data 2
        String burough2 = "b2";
        String commID2 = "c2";

        when(refuse.QueryDB(burough1, commID1, 2)).thenReturn(20);
        when(refuse.QueryDB(burough2, commID2, 2)).thenReturn(0);

        assertEquals(refuse.paper(burough1, commID1).toString(), Results.ok("20").toString());
        assertEquals(refuse.paper(burough2, commID2).toString(), Results.ok("0").toString());
    }

    @Test
    public void mgpTest() {

        // mock refuse class
        Refuse refuse = mock(Refuse.class);
        when(refuse.mgp(anyString(), anyString())).thenCallRealMethod();

        // create testing data 1
        String burough1 = "b1";
        String commID1 = "c1";

        // create testing data 2
        String burough2 = "b2";
        String commID2 = "c2";

        when(refuse.QueryDB(burough1, commID1, 3)).thenReturn(31);
        when(refuse.QueryDB(burough2, commID2, 3)).thenReturn(0);

        assertEquals(refuse.mgp(burough1, commID1).toString(), Results.ok("1").toString());
        assertEquals(refuse.mgp(burough2, commID2).toString(), Results.ok("0").toString());
    }

    @Test
    public void totalTest() {

        // mock refuse class
        Refuse refuse = mock(Refuse.class);
        when(refuse.total()).thenCallRealMethod();

        try {
            when(refuse.getTotal()).thenReturn(300);
        } catch (SQLException e) {
            //do nothing
        }

        assertEquals(refuse.total().toString(), Results.ok("300").toString());
    }
}
