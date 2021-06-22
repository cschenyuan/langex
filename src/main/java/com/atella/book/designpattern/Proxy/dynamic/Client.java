package com.atella.book.designpattern.Proxy.dynamic;

import java.lang.reflect.InvocationHandler;

/**
 * Created by chenyuan on 2017/4/6.
 */
public class Client {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Subject proxy = DynamicProxy.newProxyInstance(subject);
        proxy.request();
    }

}
