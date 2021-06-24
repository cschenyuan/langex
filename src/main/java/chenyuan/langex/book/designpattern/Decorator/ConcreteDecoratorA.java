package chenyuan.langex.book.designpattern.Decorator;

/**
 * Created by chenyuan on 2017/5/2.
 */
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void doSomethingWell() {
        System.out.println("Done perfectly via A");
    }

}
