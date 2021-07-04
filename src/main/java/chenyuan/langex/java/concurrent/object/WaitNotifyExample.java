package chenyuan.langex.java.concurrent.object;

/**
 * @author chenyuan
 */
public class WaitNotifyExample {

    private static Object lock = new Object();

    static void waiter() {
        try {
            synchronized (lock) {
                System.out.println("waiter获得锁！");
                System.out.println("waiter进入WAITING状态");
                lock.wait(15000);
                // t1被唤醒后，由WAITING状态变为BLOCKED状态，获取到锁之后，再继续执行
                // t1自行唤醒后，也需要进入BLOCKED状态，获取到锁之后，再继续执行
                System.out.println("waiter被唤醒，继续执行...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void notifier() {
        try {
            synchronized (lock) { // t2进入BLOCKED状态
                System.out.println("notifier获得锁！");
                Thread.sleep(5000); // 一些处理
                lock.notify();
                System.out.println("正在唤醒t1");
                Thread.sleep(5000);
                // 同步代码块执行完成之前，lock一直被t2占有
                System.out.println("notifier执行完毕");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(WaitNotifyExample::waiter);
        Thread t2 = new Thread(WaitNotifyExample::notifier);
        t1.setName("test-t1");
        t2.setName("test-t2");

        t1.start();

        Thread.sleep(1000);

        t2.start();

        t1.join();
        t2.join();
    }
}
