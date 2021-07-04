package chenyuan.langex.java.nio.buffer;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.util.Random;

import static chenyuan.langex.java.nio.Util.*;


/**
 * Created by chenyuan on 2017/11/2.
 */
public class BufferTest {

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

    /**
     * 翻转缓冲区
     */
    @Test
    public void testFlip() {
        CharBuffer buffer = CharBuffer.allocate(10);
        buffer.put('a').put('b').put('c');
        printBuffer(buffer);
        buffer.flip();
        printBuffer(buffer);
        buffer.flip(); // 连续翻转两次后， position和limit的值都为0
        printBuffer(buffer);
    }

    /**
     * 逐个字符的填充与排干
     */
    @Test
    public void testFillAndDrain1() {
        String data = "A buffer is a linear, finite sequence of elements of a specific primitive type. Aside from its content, the essential properties of a buffer are its capacity, limit, and position.";

        CharBuffer buffer = CharBuffer.allocate(10);

        for (int index = 0;index < data.length();) {

            // fill
            for (int i = 0; i < buffer.capacity() && (index + i) < data.length(); i ++) {
                buffer.put(data.charAt(index + i));
            }
            index += buffer.capacity();

            // flip
            buffer.flip();

            // drain
            while (buffer.hasRemaining()) {
                System.out.print(buffer.get());
            }
            System.out.println();


            // clear
            buffer.clear();
        }
    }

    /**
     * 批量填充与排干
     */
    @Test
    public void testFillAndDrain2() {
        String data = "A buffer is a linear, finite sequence of elements of a specific primitive type. Aside from its content, the essential properties of a buffer are its capacity, limit, and position.";

        CharBuffer buffer = CharBuffer.allocate(10);
        Random lengthRandom = new Random();


        for (int index = 0; index < data.length();) {

            // 每次批量填充随机数量的字符
            int length = lengthRandom.nextInt(10);
            if (length > (data.length() - index)) {
                length = (data.length() - index);
            }
            buffer.put(data.toCharArray(), index, length);
            index += length;

            // 翻转
            buffer.flip();

            // 批量排干
            char[] array = new char[10];
            int remaining = buffer.remaining();
            buffer.get(array, 0, remaining);

            System.out.print(new String(array, 0, remaining));

            // 清空
            buffer.clear();
        }
    }

    /**
     * 复制一个缓冲区，缓冲区的各属性不变，原缓冲区和新缓冲区的数组是同一个对象
     */
    @Test
    public void testDuplicate() {
        // 用外部数组作为缓冲区
        char[] buff = new char[] {'a', 'b', 'c', 'd', 'e'};
        CharBuffer buffer = CharBuffer.wrap(buff);
        printBuffer(buffer);

        Buffer buffer1 = buffer.duplicate();
        printBuffer(buffer1);

        // 对数组的修改，会同时对原缓冲区和新缓冲区都生效
        buff[0] = 'A';
        buffer.position(0);
        buffer1.position(0);
        printBuffer(buffer);
        printBuffer(buffer1);
    }

    /**
     * slice() 也能复制一个缓冲区，但只会复制position到limit之间的元素，并且capacity的值等于limit值
     * 缓冲区的数组还是同一个对象
     */
    @Test
    public void testSlice() {
        CharBuffer buffer = CharBuffer.allocate(10);

        buffer.put('a').put('b').put('c').put('d');
        buffer.flip();
        buffer.get();
        printBuffer(buffer);

        // 通过slice()
        CharBuffer buffer1 = buffer.slice();
        printBuffer(buffer1);
    }
}
