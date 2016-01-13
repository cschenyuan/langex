package com.atella.book.conarts.jmm;

/**
 * Created by yuan on 15/12/28.
 */
public class DoubleCheckedLocking {
    private static Instance instance;

    // incorrect optimization for lazy initialization
    public static Instance getInstance() {
        if(instance == null) {
            synchronized (DoubleCheckedLocking.class) {
                if(instance == null) {
                    instance = new Instance();
                }
            }
        }
        return instance;
    }
}
