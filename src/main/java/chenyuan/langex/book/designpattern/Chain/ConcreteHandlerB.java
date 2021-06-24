package chenyuan.langex.book.designpattern.Chain;

/**
 * Created by chenyuan on 2017/4/24.
 */
public class ConcreteHandlerB extends Handler {

    @Override
    public Level getHandlerLevel() {
        return new Level(1);
    }

    @Override
    public Response handleSomething(Request request) {
        System.out.println("Handler B done.");
        return new Response();
    }
}
