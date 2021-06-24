package chenyuan.langex.book.designpattern.singleton;

/**
 * Created by chenyuan on 2017/2/23.
 */
public class InnerSingleton implements Singleton {

    private static class SingleHolder {
        private final static Singleton instance = new InnerSingleton();
    }

    public static Singleton getInstance() {
        return SingleHolder.instance;
    }

    @Override
    public void doSomething() { }
}
