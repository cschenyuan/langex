package chenyuan.langex.java.nio.channel;

import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by chenyuan on 2017/11/14.
 */
public class FileLock {

    @Test
    public void testLock() throws Exception {
        File file = new File("temp.lock");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");

        FileChannel channel = raf.getChannel();
        java.nio.channels.FileLock lock = channel.tryLock();
        if (lock != null) {
            System.out.println("Acquired an exclusive lock " + lock.toString());
            Thread.sleep(60000);
            lock.release();
        }


        System.out.println(raf.readLine());
        raf.close();
    }

    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("/Users/yuan/Devel/studio/atella/temp.lock", "rw");

        FileChannel fch = raf.getChannel();
        java.nio.channels.FileLock lock = fch.tryLock();
        if (lock != null) {
            try {
                raf.writeBytes("thread-2");
            } finally {
                lock.release();
            }
        } else {
            System.out.println("Can not acquire the lock.");
        }

        raf.close();
    }

}
