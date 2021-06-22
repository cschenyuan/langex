package com.atella.book.designpattern.Prototype;

/**
 * Created by chenyuan on 2017/4/12.
 */
public class Client {

    public static void main(String[] args) {
        Prototype prototype = new ConcretePrototype();
        Prototype copy = prototype.clone();
    }

}
