package chenyuan.langex.java.nio.buffer;

import org.junit.Test;
import sun.nio.ch.DirectBuffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

/**
 * Created by chenyuan on 2017/11/2.
 */
public class BufferTest {


    private static void printBuffer(Buffer buffer) {
        System.out.println("position = " + buffer.position()
                + ", limit = " + buffer.limit()
                + ", capacity = " + buffer.capacity());
        if (buffer instanceof ByteBuffer) {
            System.out.println(new String(((ByteBuffer)buffer).array()));
        } else if (buffer instanceof CharBuffer) {
            System.out.println(Arrays.toString((char[]) buffer.array()));
        } else if (buffer instanceof IntBuffer) {
            System.out.println(Arrays.toString((int[]) buffer.array()));
        } else {
            System.out.println(buffer);
        }
    }

    @Test
    public void testBuffer() {
        IntBuffer buffer = IntBuffer.allocate(10);
    }

    @Test
    public void testCompact() {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i=0; i<8; i++) {
            buffer.put((byte)i);
        }
        printBuffer(buffer);

        buffer.flip();
        printBuffer(buffer);

        for (int i=0; i<4; i++) {
            buffer.get();
        }
        printBuffer(buffer);

        buffer.compact();
        printBuffer(buffer);
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        printBuffer(buffer);
    }

    @Test
    public void testFlip() {
        CharBuffer buffer = CharBuffer.allocate(10);
        buffer.put('a').put('b').put('c');
        printBuffer(buffer);
        buffer.flip();
        printBuffer(buffer);
        buffer.flip();
        printBuffer(buffer);
    }
}
