package chenyuan.langex.java.nio.channel;

import chenyuan.langex.java.nio.Util;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author chenyuan
 */
public class SocketChannelExample {

    public static void main(String[] args) {
        testServerSocketChannel();
    }

    static void testServerSocketChannel() {
        try {
            ServerSocketChannel ssCh = ServerSocketChannel.open();
            ssCh.configureBlocking(false);
            ssCh.bind(new InetSocketAddress(8888));

            ByteBuffer buffer = ByteBuffer.allocateDirect(10);
            byte[] heapBuff = new byte[10];
            while (true) {
                SocketChannel sCh = ssCh.accept(); // ssCH为非阻塞模式，如果是非连接状态，会立即返回null
                if (sCh == null) {
                    System.out.println("No connection is available");
                    Thread.sleep(1000);
                } else {
                    System.out.println("Accepted: " + sCh.getRemoteAddress());
//                    sCh.configureBlocking(false); // 设置为非阻塞模式，如果缓冲区没数据，就立即返回

                    // 处理客户端消息
                    while (sCh.read(buffer) > 0) {
                        buffer.flip();
                        buffer.get(heapBuff, 0, buffer.limit());
                        for (int i = 0; i < buffer.limit(); i++) {
                            System.out.print((char)buffer.get(i));
                        }
                        System.out.println();

                        if (buffer.get(buffer.limit()-1) == '\n') {
                            buffer.clear();
                            break;
                        }
                        buffer.clear();
                    }

                    // 向客户端返回消息
                    sCh.write(ByteBuffer.wrap("Accepted".getBytes()));
                    buffer.clear();
                    sCh.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
