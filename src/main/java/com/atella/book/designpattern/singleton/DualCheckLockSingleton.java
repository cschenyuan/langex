package com.atella.book.designpattern.singleton;

/**
 * Created by chenyuan on 2017/2/23.
 */
public class DualCheckLockSingleton implements Singleton {

    private static volatile Singleton instance;

    private DualCheckLockSingleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (DualCheckLockSingleton.class) {
                if (instance == null)
                    instance = new DualCheckLockSingleton();
            }
        }
        return instance;
    }

    @Override
    public void doSomething() { }
}
