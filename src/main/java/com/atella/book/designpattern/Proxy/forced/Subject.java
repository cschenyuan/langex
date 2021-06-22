package com.atella.book.designpattern.Proxy.forced;

/**
 * Created by chenyuan on 2017/4/5.
 */
public interface Subject {

    public void request();

    public Proxy getProxy();

    default boolean isProxy() {
        return false;
    }
}
