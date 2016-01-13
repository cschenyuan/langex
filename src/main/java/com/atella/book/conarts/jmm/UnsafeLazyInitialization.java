package com.atella.book.conarts.jmm;

/**
 * Created by yuan on 15/12/28.
 */
public class UnsafeLazyInitialization {
    private static Instance instance;
    public static Instance getInstance() {
        if(instance == null) { // executed by #A
            instance = new Instance(); // executed by #B
        }
        return instance;
    }
}

class Instance {
}
