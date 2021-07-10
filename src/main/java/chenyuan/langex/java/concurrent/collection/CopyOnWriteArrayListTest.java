package chenyuan.langex.java.concurrent.collection;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * {@link java.util.concurrent.CopyOnWriteArrayList} 是ArrayList的线程安全版本
 * 在写的时候(add(e))先复制一份数据，在复制的数据上进行add操作，然后将新的数据替换旧的数据
 * @author chenyuan
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        new Thread(() -> {
            while (true) {
                list.add(new Random().nextInt(100) + "");
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                for (String s : list) { // 遍历的过程中即使list有更新，也不会报错
                    System.out.print(s + ",");
                }
                System.out.println();
                list.clear();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
