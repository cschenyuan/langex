package chenyuan.langex.book.designpattern.Decorator;

/**
 * Created by chenyuan on 2017/5/2.
 */
public class ConcreteComponent implements Component {

    @Override
    public void doSomething() {
        System.out.println("Operation done.");
    }

}
