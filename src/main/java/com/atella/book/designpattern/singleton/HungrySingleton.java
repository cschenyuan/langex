package com.atella.book.designpattern.singleton;

/**
 * Created by chenyuan on 2017/2/23.
 */
public class HungrySingleton implements Singleton {

    private final static Singleton instance = new HungrySingleton();

    private HungrySingleton() {}

    public static Singleton getInstance() {
        return instance;
    }

    @Override
    public void doSomething() { }
}
