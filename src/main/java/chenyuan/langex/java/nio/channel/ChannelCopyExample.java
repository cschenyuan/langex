package chenyuan.langex.java.nio.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author chenyuan
 */
public class ChannelCopyExample {

    public static void main(String[] args) {
        testChannelCopy1();
    }

    public static void testChannelCopy1() {
        try (
            ReadableByteChannel source = Channels.newChannel(System.in);
            WritableByteChannel dest = Channels.newChannel(System.out)
        ) {

            ByteBuffer buffer = ByteBuffer.allocateDirect(10 * 1024);

            while (source.read(buffer) != -1) {
                buffer.flip();
                dest.write(buffer);
                buffer.compact();
            }

            buffer.flip();

            while (buffer.hasRemaining()) {
                dest.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void testChannelCopy2() {
        try (ReadableByteChannel source = Channels.newChannel(System.in);
            WritableByteChannel dest = Channels.newChannel(System.out)
        ) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(10 * 1024);
            while (source.read(buffer) != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    dest.write(buffer);
                }
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
