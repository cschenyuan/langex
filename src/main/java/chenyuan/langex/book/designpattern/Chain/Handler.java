package chenyuan.langex.book.designpattern.Chain;

/**
 * Created by chenyuan on 2017/4/24.
 */
public abstract class Handler {

    private Handler nextHandler;

    public final Response handle(Request request) {
        Response response = null;
        if (getHandlerLevel().equals(request.getLevel())) {
            response = handleSomething(request);
        } else if (nextHandler != null) {
            response = nextHandler.handle(request);
        } else {
            //
        }
        return response;
    }

    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    public abstract Level getHandlerLevel();

    public abstract Response handleSomething(Request request);
}
