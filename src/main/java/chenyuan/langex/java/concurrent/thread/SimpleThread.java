package chenyuan.langex.java.concurrent.thread;

/**
 * @author chenyuan
 */
public class SimpleThread extends Thread {

    private boolean toStop;

    @Override
    public void run() {
        System.out.println("线程开始");
        while (!toStop) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程结束");
    }

    public void asyncStop() {
        this.toStop = true;
    }
}
