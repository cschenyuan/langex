package com.atella.book.designpattern.Proxy.forced;

/**
 * Created by chenyuan on 2017/4/5.
 */
public class Client {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Proxy proxy = subject.getProxy();
//        subject.request();
        proxy.request();
    }
}
