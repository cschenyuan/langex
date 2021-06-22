package com.atella.book.designpattern.Stragegy;

/**
 * Created by chenyuan on 2017/5/3.
 */
public class Client {

    public static void main(String[] args) {
        int l = 33;
        int r = 21;
        System.out.println("result> " + Calculator.ADD.exec(l,r));
        System.out.println("result> " + Calculator.SUB.exec(l,r));
    }
}
