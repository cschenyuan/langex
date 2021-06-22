package com.atella.book.designpattern.AbstractFactory;

/**
 * Created by chenyuan on 2017/3/7.
 */
public class Creator2 extends AbstractCreator {

    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    public AbstractProductB createProductB() {
        return new ProductB2();
    }

}
