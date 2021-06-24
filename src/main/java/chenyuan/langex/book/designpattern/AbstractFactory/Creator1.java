package chenyuan.langex.book.designpattern.AbstractFactory;

/**
 * Created by chenyuan on 2017/3/7.
 */
public class Creator1 extends AbstractCreator {

    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    public AbstractProductB createProductB() {
        return new ProductB1();
    }

}
