package chenyuan.langex.java.concurrent;


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
