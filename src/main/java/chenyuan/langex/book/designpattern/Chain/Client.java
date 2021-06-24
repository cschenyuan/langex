package chenyuan.langex.book.designpattern.Chain;

/**
 * Created by chenyuan on 2017/4/24.
 */
public class Client {

    public static void main(String[] args) {
        Request request = new Request(new Level(1));

        Handler handler1 = new ConcreteHandlerA();
        Handler handler2 = new ConcreteHandlerB();
        handler1.setNextHandler(handler2);

        handler1.handle(request);
    }
}
