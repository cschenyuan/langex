package com.atella.java.concurrent;


public class MyTask implements Runnable {
    private int index;

    public MyTask(int index) {
        this.index = index;
    }

    @Override
    public void run() {
      System.out.println(index);
    }
}
