package com.atella.book.designpattern.Decorator;

/**
 * Created by chenyuan on 2017/5/2.
 */
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void doSomethingWell() {
        System.out.println("Done perfectly via B");
    }
}
