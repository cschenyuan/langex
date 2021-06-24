package chenyuan.langex.book.designpattern.Proxy.normal;

import chenyuan.langex.book.designpattern.Proxy.Subject;

/**
 * Created by chenyuan on 2017/3/22.
 */
public class Proxy implements Subject {

    private Subject realSubject;

    public Proxy(String name) {
        this.realSubject = new RealSubject(this, name);
    }

    public void request() {
        before();
        this.realSubject.request();
        after();
    }

    private void before() {}

    private void after() {}
}
