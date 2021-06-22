package com.atella.book.designpattern.Proxy;

/**
 * Created by chenyuan on 2017/3/22.
 */
public class Client {

    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);

        proxy.request();
    }
}
