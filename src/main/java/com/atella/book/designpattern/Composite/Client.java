package com.atella.book.designpattern.Composite;

/**
 * Created by chenyuan on 2017/5/11.
 */
public class Client {

    public static void main(String[] args) {
        Composite root = new Composite();
        root.doSomething();

        Composite branch = new Composite();
        root.add(branch);

        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();
        branch.add(leaf1);
        branch.add(leaf2);

        root.doSomething();
        branch.getChildren()
                .forEach(Component::doSomething);
    }

}
