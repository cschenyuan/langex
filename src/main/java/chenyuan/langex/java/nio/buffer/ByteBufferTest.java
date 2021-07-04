package chenyuan.langex.java.nio.buffer;

import org.junit.Test;

import java.nio.*;

import static chenyuan.langex.java.nio.Util.*;

/**
 * @author chenyuan
 */
public class ByteBufferTest {

    /**
     * 用ByteBuffer来创建各种类型的视图缓冲区
     */
    @Test
    public void test() {

        /*
         * type     byte size
         * ----     ------
         * byte     1
         * char     2
         * short    2
         * int      4
         * float    4
         * long     8
         * double   8
         */

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(20);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
        FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
        LongBuffer longBuffer = byteBuffer.asLongBuffer();
        DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();

        byteBuffer.put((byte)'H');
        byteBuffer.put((byte)'E');
        byteBuffer.put((byte)'L');
        byteBuffer.put((byte)'L');
        byteBuffer.put((byte)'O');

        printBuffer(byteBuffer, false);
        printBuffer(charBuffer, false);
        printBuffer(shortBuffer, false);
        printBuffer(intBuffer, false);
        printBuffer(floatBuffer, false);
        printBuffer(longBuffer, false);
        printBuffer(doubleBuffer, false);
    }
}
