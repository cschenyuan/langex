package chenyuan.langex.book.designpattern.Builder;

/**
 * Created by chenyuan on 2017/3/13.
 */
public class Client {

    public static void main(String[] args) {
        Director director = new Director();
        Product productA = director.getProductA();
        Product productB = director.getProductB();
    }

}
