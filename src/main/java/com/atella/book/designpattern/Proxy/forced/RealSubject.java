package com.atella.book.designpattern.Proxy.forced;

/**
 * Created by chenyuan on 2017/4/5.
 */
public class RealSubject implements Subject {

    private Proxy proxy;

    public RealSubject() {
    }

    @Override
    public void request() {
        // check if subject has a proxy
        if (isProxy())
            throw new RuntimeException(
                    "Please assign a proxy for the subject");
        System.out.println("Requesting");
    }

    @Override
    public Proxy getProxy() {
        if (proxy == null)
            this.proxy = new RequestProxy(this);
        return this.proxy;
    }

    @Override
    public boolean isProxy() {
        return proxy != null;
    }
}
