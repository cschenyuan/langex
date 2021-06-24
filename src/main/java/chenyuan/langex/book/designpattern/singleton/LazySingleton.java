package chenyuan.langex.book.designpattern.singleton;

/**
 * Created by chenyuan on 2017/2/23.
 */
public class LazySingleton implements Singleton {

    private static Singleton instance;

    private LazySingleton(){}

    public synchronized static Singleton getInstance() {
        if (instance == null)
            instance = new LazySingleton();
        return instance;
    }

    @Override
    public void doSomething() { }

}
