package chenyuan.langex.java.nio.channel;

import chenyuan.langex.java.nio.Util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author chenyuan
 */
public class ScatterAndGatherExample {

    private static final String CUR_DIR = "src/main/java/"
            + ScatterAndGatherExample.class.getPackage().getName().replaceAll("\\.", "/");


    public static void main(String[] args) {
        testScatteringForRead();
        testGatheringForWrite();
    }

    static void testScatteringForRead() {

        try (RandomAccessFile srcFile = new RandomAccessFile(CUR_DIR + "/data.txt", "r");
             ScatteringByteChannel srcChannel = srcFile.getChannel();
        ) {
            // 堆外缓冲区阵列
            ByteBuffer[] buffers = new ByteBuffer[]{
                    ByteBuffer.allocateDirect(2),
                    ByteBuffer.allocateDirect(4),
                    ByteBuffer.allocateDirect(8),
                    ByteBuffer.allocateDirect(16)
            };

            // 用户空间缓冲区
            byte[] heapBuffer = new byte[16];

            // 通过通道读取文件数据，依次填充每个缓冲区
            while (srcChannel.read(buffers) > 0) { // <= 30
                for (int i = 0; i < buffers.length; i++) {
                    ByteBuffer buffer = buffers[i];
//                    Util.printBuffer(buffer, false);

                    // 翻转
                    buffer.flip();

                    // 拷贝至用户缓冲区
                    buffer.get(heapBuffer, 0, buffer.limit());
                    System.out.println("buffer[" + i + "]: " + new String(heapBuffer, 0, buffer.limit()));

                    // 清空
                    buffer.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void testGatheringForWrite() {
        String data = "A channel that can write bytes from a sequence of buffers.\n" +
                "A gathering write operation writes, in a single invocation, a sequence of bytes from one or more of a given sequence of buffers. Gathering writes are often useful when implementing network protocols or file formats that, for example, group data into segments consisting of one or more fixed-length headers followed by a variable-length body. Similar scattering read operations are defined in the ScatteringByteChannel interface.";
        System.out.println("data size: " + data.length());

        try (FileOutputStream fos = new FileOutputStream(CUR_DIR + "/data.txt");
             GatheringByteChannel channel = fos.getChannel()
        ) {
            // 堆外缓冲区阵列
            ByteBuffer[] buffers = new ByteBuffer[]{
                    ByteBuffer.allocateDirect(64),
                    ByteBuffer.allocateDirect(128),
                    ByteBuffer.allocateDirect(256),
                    ByteBuffer.allocateDirect(512),
                    ByteBuffer.allocateDirect(1024)
            };

            // 依次填充缓冲区
            for (int i = 0; i < data.length(); ) {
                for (ByteBuffer buffer : buffers) {
                    int numCanFilled = buffer.capacity()/2;
                    if (numCanFilled >= data.length() - i) numCanFilled = data.length() - i;
                    System.out.println(i + ", " + numCanFilled);
                    Util.printBuffer(buffer);
                    buffer.put(data.substring(i, i + numCanFilled).getBytes(StandardCharsets.UTF_8));
                    i += numCanFilled;
                }
            }

            // 汇集缓冲区阵列数据，通过管道写入文件
            channel.write(buffers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
