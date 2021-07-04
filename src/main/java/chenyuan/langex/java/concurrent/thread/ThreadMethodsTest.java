package chenyuan.langex.java.concurrent.thread;

/**
 * @author chenyuan
 */
public class ThreadMethodsTest {

    public static void main(String[] args) throws Exception {
        Object object = new Object();
        Thread t = new Thread();

        /* Object方法 */

        // 是当前线程进入WAITING，被放入到对象的等待池（WaitSet)，等待唤醒
        // 注意：必须在synchronized代码块中使用，否则抛IllegalMonitorStateException异常
        object.wait();
        // 等待池中第一个线程被唤醒，从等待池中放入到锁池中，获取锁，线程获取到锁后就回到wait方法处继续执行
        // 注意：必须在synchronized代码块中使用, 否则抛IllegalMonitorStateException异常
        object .notify();
        // 所有线程被唤醒
        object.notifyAll();

        /* 静态方法 */

        // 让出CPU，很少使用
        Thread.yield();

        // 进入TIMED_WAITING，不会释放锁
        Thread.sleep(1000);

        /* 实例方法 */

        t.setDaemon(true);
        t.isDaemon();
        t.setPriority(0);
        t.getPriority();

        t.start();

        // 等待一个线程执行结束。
        // 当前线程(main)循环检查目标线程(t)的alive状态，
        //  如果为alive，就调用t的wait()方法，使main进入WAITING状态，等t执行完成后，唤醒main
        t.join();

        t.interrupt();
        t.isInterrupted();

        t.isAlive();

        t.getState();
    }
}
