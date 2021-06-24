package chenyuan.langex.book.designpattern.Adapter;

/**
 * Created by chenyuan on 2017/5/4.
 */
public class Client {

    public static void main(String[] args) {
        Target origin = new ConcreteTarget();
        origin.request();

        Target special = new Adapter();
        special.request();
    }
}
