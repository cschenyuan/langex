package com.atella.book.designpattern.Proxy;

/**
 * Created by chenyuan on 2017/3/22.
 */
public class Proxy implements Subject {

    private Subject realSubject;

    public Proxy() {
        this(new Proxy());
    }

    public Proxy(Subject subject) {
        this.realSubject = subject;
    }

    public void request() {
        before();
        this.realSubject.request();
        after();
    }

    private void before() {}

    private void after() {}
}
