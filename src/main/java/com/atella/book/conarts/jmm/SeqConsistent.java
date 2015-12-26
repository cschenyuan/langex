package com.atella.book.conarts.jmm;

class ReorderExample {
  int a = 0;
  boolean flag = false;

  // instructions in this method will be reodered
  void write () {
    a = 1; // #1
    flag = true; // #2
  }

  // instructions in this method will be reodered
  void read () {
    if (flag) { // #3
      int i = a * a; // #4
    }
  }
}

class SynchronizedExample {
  int a = 0;
  boolean flag = false;

  void f1() {
    synchronized(this) {
      System.out.print("synchronized code block");
    }
  }

  // instructions in this method will be not reodered
  synchronized void write() {
    a = 1;
    flag = true;
  }

  // instructions in this method will be not reodered
  synchronized void read () {
    if (flag) {
      int i = a * a;
    }
  }
}

public class SeqConsistent {

  public static void main(String[] args) throws InterruptedException{
    test01();
  }

  static void test01() throws InterruptedException {
    ReorderExample re = new ReorderExample();
    SynchronizedExample se = new SynchronizedExample();

    Thread t1 = new Thread( () -> {
      re.write();
      se.write();
    });
    Thread t2 = new Thread( () -> {
      re.read();
      se.read();
    });

    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }

}
