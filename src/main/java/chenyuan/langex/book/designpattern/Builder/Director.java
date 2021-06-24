package chenyuan.langex.book.designpattern.Builder;

/**
 * Created by chenyuan on 2017/3/13.
 */
public class Director {

    private Builder builder = new ConcreteBuilder();

    public Product getProductA() {
        builder.setPart("A");
        return builder.build();
    }

    public Product getProductB() {
        builder.setPart("A");
        return builder.build();
    }
}
