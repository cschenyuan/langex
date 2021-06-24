package chenyuan.langex.book.designpattern.Chain;

/**
 * Created by chenyuan on 2017/4/24.
 */
public class ConcreteHandlerA extends Handler {

    @Override
    public Response handleSomething(Request request) {
        System.out.println("Handler A done.");
        return new Response();
    }

    @Override
    public Level getHandlerLevel() {
        return new Level(0);
    }
}
