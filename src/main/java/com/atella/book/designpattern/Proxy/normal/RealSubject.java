package com.atella.book.designpattern.Proxy.normal;

import com.atella.book.designpattern.Proxy.Subject;

/**
 * Client can only create an instance of Proxy rather than RealSubject
 * Created by chenyuan on 2017/3/22.
 */
public class RealSubject implements Subject {

    private String name;

    public RealSubject(Subject subject,String name) {
        if (subject != null)
            throw new RuntimeException("Cannot create a instance of RealSubject");
        this.name = name;
    }

    public void request() {

    }
}
