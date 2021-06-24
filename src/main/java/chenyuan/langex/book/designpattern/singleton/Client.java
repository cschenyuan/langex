package chenyuan.langex.book.designpattern.singleton;

/**
 * Created by chenyuan on 2017/2/23.
 */
public class Client {

    public static void main(String[] args) {

        Singleton s1 = HungrySingleton.getInstance();
        s1.doSomething();

        Singleton s2 = LazySingleton.getInstance();
        s2.doSomething();

        Singleton s3 = DualCheckLockSingleton.getInstance();
        s3.doSomething();

        Singleton s4 = EnumSingleton.INSTANCE;
        s4.doSomething();

        Singleton s5 = InnerSingleton.getInstance();
        s5.doSomething();
    }

}
