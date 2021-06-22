package com.atella.book.designpattern.Adapter;

/**
 * Created by chenyuan on 2017/5/4.
 */
public class Adapter extends Adaptee implements Target {

    public void request() {
        specialRequest();
        System.out.println("Request was processed.");
    }

}
