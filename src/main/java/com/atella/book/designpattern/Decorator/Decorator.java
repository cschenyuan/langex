package com.atella.book.designpattern.Decorator;

/**
 * Created by chenyuan on 2017/5/2.
 */
public abstract class Decorator implements Component {

    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public abstract void doSomethingWell();

    public void doSomething() {
        component.doSomething();
        doSomethingWell();
    }

}
