package chenyuan.langex.book.designpattern.Decorator;

/**
 * Created by chenyuan on 2017/5/2.
 */
public class Client {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component = new ConcreteDecoratorA(component);
        component = new ConcreteDecoratorB(component);
        component.doSomething();
    }

}
