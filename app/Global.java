import play.libs.F.Promise;
import play.mvc.Http.RequestHeader;
import play.mvc.Result;
import play.mvc.Results;
import play.GlobalSettings;
import play.libs.F;
import play.Application;

/**
 * Created by madhuripalle on 9/14/15.
 */
public class Global extends GlobalSettings {

    Promise<Result> myPromise = Promise.promise(() -> {
        // TODO - Add Implementation here.
        return Results.ok("0");
    });

    @Override
    /*Called when an exception occurred - custom error page*/
    public F.Promise<Result> onError(RequestHeader request, Throwable t) {
        return myPromise;
    }

    @Override
    /*Called when no action was found to serve a request - alternate 404 page*/
    public F.Promise<Result> onHandlerNotFound(RequestHeader request) {
        return myPromise;
    }


    @Override
    /*Called when an action has been found, but the request parsing has failed*/
    public F.Promise<Result> onBadRequest(RequestHeader request, String error) {
        return myPromise;
    }

}