package chenyuan.langex.book.conarts.basic;

import java.util.concurrent.TimeUnit;

public class Interrupted {

    static class SleepRunner implements Runnable {
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable {
        public void run() {
            while (true) {

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);
        Thread buzyThread = new Thread(new BusyRunner(),"BusyThread");
        buzyThread.setDaemon(true);
        sleepThread.start();
        buzyThread.start();

        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        buzyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + buzyThread.isInterrupted());
        SleepUtils.second(2);
    }
}
