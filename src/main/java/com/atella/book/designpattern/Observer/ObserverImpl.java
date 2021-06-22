package com.atella.book.designpattern.Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by chenyuan on 2017/5/15.
 */
public class ObserverImpl implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("State has benn changed");
    }
}
