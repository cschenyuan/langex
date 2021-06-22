package com.atella.book.designpattern.Proxy.forced;

/**
 * Created by chenyuan on 2017/4/5.
 */
public class RequestProxy implements Proxy {

    private Subject subject;

    public RequestProxy(Subject subject) {
        this.subject = subject;
    }

    public void before() {
        System.out.println("Before the request");
    }

    public void after() {
        System.out.println("After the request");
    }

    @Override
    public void request() {
        before();
        subject.request();
        after();
    }

    @Override
    public Proxy getProxy() {
        return this;
    }

    @Override
    public boolean isProxy() {
        return true;
    }
}
