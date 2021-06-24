package chenyuan.langex.book.designpattern.FactoryMethod;

/**
 * Created by chenyuan on 2017/3/1.
 */
public class Client {

    public static void main(String[] args) {
        Creator creator = new CreatorImpl();

        ProductA p1 = creator.create(ProductA.class);
        ProductB p2 = creator.create(ProductB.class);
    }
}
