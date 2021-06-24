package chenyuan.langex.java.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yuan on 16/3/5.
 */
public class SimpleChannelTest {

    public static void main(String[] args) {
        try {
            example04();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void println(Object msg) {
        print(msg.toString() + "\n");
    }

    private static void print(Object msg) {
        System.out.print(msg);
    }

    public static void example01 () throws FileNotFoundException,IOException {
        String filepath = "/Users/yuan/welcome";
        RandomAccessFile file = new RandomAccessFile(filepath, "r");
        FileChannel inChannel = file.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(48);
        int readBytes = inChannel.read(buffer); // read into buffer
        while (readBytes != -1) {
            println("read bytes: " + readBytes);
            buffer.flip(); // switch the buffer from writing mode into reading mode
            while (buffer.hasRemaining()) {
                print((char) buffer.get()); // read 1 byte at a time
            }

            buffer.clear(); // make buffer ready for writing
            readBytes = inChannel.read(buffer);
        }
        file.close();
    }

    // scatter : read data from a channel into multiple buffers
    public static void example02() throws Exception {
        String filepath = "/Users/yuan/welcome";
        RandomAccessFile file = new RandomAccessFile(filepath, "r");
        FileChannel inChannel = file.getChannel();

        ByteBuffer buffer1 = ByteBuffer.allocate(50);
        ByteBuffer buffer2 = ByteBuffer.allocate(30);
        ByteBuffer[] bufferArray = {buffer1, buffer2};

        long readBytes = inChannel.read(bufferArray);
        while(readBytes != -1L) {
            println("read bytes: " + readBytes);
            for(ByteBuffer buffer : bufferArray) {
                buffer.flip();
                println("buff limit: " + buffer.limit());
                while (buffer.hasRemaining()) {
                    print((char) buffer.get());
                }
                println("");
                buffer.clear();
            }
            readBytes = inChannel.read(bufferArray);
        }
        file.close();
    }

    // gather : write data from multiple buffers into a channel
    public static void example03() throws Exception {
        String filepath = "/Users/yuan/readme";
        RandomAccessFile file = new RandomAccessFile(filepath, "rw");
        FileChannel outChannel = file.getChannel();

        ByteBuffer buffer1 = ByteBuffer.allocate(50);
        ByteBuffer buffer2 = ByteBuffer.allocate(30);
        buffer1.put("ASDNO-SDAON-NOISA".getBytes()).flip();
        buffer2.put("NONOS-NOOOI".getBytes()).flip();
        ByteBuffer[] bufferArray = {buffer1, buffer2};

        outChannel.write(bufferArray);
        outChannel.force(false);
        println("File Size: " + outChannel.size());
        outChannel.close();
        file.close();
    }

    public static void example04() throws Exception {
        RandomAccessFile srcfile = new RandomAccessFile("/Users/yuan/readme", "r");
        FileChannel srcChannel = srcfile.getChannel();
        RandomAccessFile destfile =
                new RandomAccessFile("/Users/yuan/readme_b", "rw");
        FileChannel destChannel = destfile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(2);
        while (true) {
            buffer.clear();
            int readBytes = srcChannel.read(buffer);
            if (readBytes == -1) break;
            buffer.flip();
            destChannel.write(buffer);
        }

        destChannel.force(false);
        destChannel.close();
        destfile.close();
    }
}
