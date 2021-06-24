package chenyuan.langex.java.ref.e1;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author chenyuan
 */
public class PhantomReferenceTest {

    public static void main(String[] args) {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        Queue<Reference<Object>> refs = new ArrayBlockingQueue<>(1000);

        new Thread(() -> {
            while (true) {
                // 每次创建1MB大小的对象
                Object o = new byte[1024*1024];
                PhantomReference<Object> pr = new PhantomReference<>(o, referenceQueue);
                refs.add(pr);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println("=== GC开始 ===");

        while (true) {
            System.out.println("refs queue size: " + refs.size());
            for (Reference<Object> ref : refs) {
                if (ref != null && ref.isEnqueued()) {
                    System.out.println("虚引用对应的对象已被销毁 " + ref);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
