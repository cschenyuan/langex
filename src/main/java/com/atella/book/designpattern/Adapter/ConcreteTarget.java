package com.atella.book.designpattern.Adapter;

/**
 * Created by chenyuan on 2017/5/4.
 */
public class ConcreteTarget implements Target {

    public void request() {
        System.out.println("This a native request.");
        System.out.println("Request was processed.");
    }

}
