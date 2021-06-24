package chenyuan.langex.java.nio.channel;

import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenyuan on 2017/11/16.
 *
 * 对映射文件修改对其他进程即时可见
 */
public class MappedFileTest {

    @Test
    public void testNormal() throws Exception {
        String fileName = "foo.txt";
        RandomAccessFile raf = new RandomAccessFile(fileName, "r");

        while (true) {
            raf.seek(0);
            System.out.println(raf.readLine());
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    @Test
    public void testMapped() throws Exception {
        String fileName = "foo.txt";
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        FileChannel fch = raf.getChannel();
        MappedByteBuffer mappedBuff = fch.map(
                FileChannel.MapMode.READ_WRITE, 0, 0x400);
        for (int i=0; i<100; i++) {
            mappedBuff.put(String.valueOf(i).getBytes());
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

}
