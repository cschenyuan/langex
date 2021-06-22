package com.atella.book.designpattern.Proxy.dynamic;

/**
 * Created by chenyuan on 2017/4/6.
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("Requesting ...");
    }
}
