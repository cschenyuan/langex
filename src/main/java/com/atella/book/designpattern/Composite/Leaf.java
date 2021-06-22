package com.atella.book.designpattern.Composite;

/**
 * Created by chenyuan on 2017/5/11.
 */
public class Leaf extends Component {

    @Override
    public void doSomething() {
        System.out.println("Action was done.");
    }

}
