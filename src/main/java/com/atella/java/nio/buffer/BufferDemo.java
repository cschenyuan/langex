package com.atella.java.nio.buffer;

import org.junit.Test;
import sun.nio.ch.DirectBuffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * Created by chenyuan on 2017/11/2.
 */
public class BufferDemo {


    private static void printBuffer(Buffer buffer) {
        System.out.println(buffer.toString());
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
}
