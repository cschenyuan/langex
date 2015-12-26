package com.atella.java.concurrent;

import java.util.Map;
import java.util.TreeMap;

public class VolatileTest {

  public static void main(String[] args) {
    try {
      test01();
    } catch (Exception e) {

    }
  }

  static volatile Map<Long,String> timeline = new TreeMap<Long,String>();

  static void test01() throws InterruptedException{
    final SharedObject so = new SharedObject();

    Thread t1 = new Thread(
      () -> {
          for (int i=0;i<10;i++) {
            so.counter++;
            timeline.put(System.nanoTime(),"write " + so.counter);
          }
        }
    );
    Thread t2 = new Thread(){
      @Override
        public void run() {
          for(int i=0;i<10;i++) {
            timeline.put(System.nanoTime(),"read " + so.counter);
          }
        }
    };
    t1.start();
    t2.start();

    try{
      t1.join();
      t2.join();
    } catch (Exception e) {

    }
    for(Long l : timeline.keySet()) {
      System.out.println(l + " " + timeline.get(l));
    }
  }
}

class SharedObject {
//public volatile int counter;
  public int counter;

  public SharedObject() {
    this.counter = 0;
  }
}
