package com.atella.book.designpattern.Observer;

import java.util.Observable;

/**
 * Created by chenyuan on 2017/5/15.
 */
public class Subject extends Observable {


    public void setChanged() {
        super.setChanged();
    }

    public void doSomething() {
        System.out.println();
    }

}
