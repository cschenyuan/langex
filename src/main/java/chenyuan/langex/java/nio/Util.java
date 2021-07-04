package chenyuan.langex.java.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

/**
 * @author chenyuan
 */
public class Util {

    public static void printBuffer(Buffer buffer) {
        printBuffer(buffer, false);
    }

    public static void printBuffer(Buffer buffer, boolean printData) {
        System.out.println("[" + buffer.getClass().getSimpleName()
                + "] position = " + buffer.position()
                + ", remaining = " + buffer.remaining()
                + ", limit = " + buffer.limit()
                + ", capacity = " + buffer.capacity());
        if (!printData) {
            return;
        }
        if (!buffer.hasArray()) {
            System.out.println(buffer);
        }
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
}
