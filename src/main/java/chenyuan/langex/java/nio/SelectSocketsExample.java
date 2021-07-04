package chenyuan.langex.java.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 简单的创建了使用了Selector的服务器，将ServerSocketChannel注册到Selector
 * 单线程处理ACCEPT，READ等操作
 * @author chenyuan
 */
public class SelectSocketsExample {

    private ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

    public void serve() throws Exception {

        Selector selector = Selector.open();

        System.out.println(selector);
        System.out.println(selector.provider());

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false); // 设置为非阻塞模式，默认是阻塞模式
        serverChannel.bind(new InetSocketAddress(8888));
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int n = selector.select();

            if (n == 0) {
                continue;
            }

            Iterator<SelectionKey> it = selector.selectedKeys().iterator();

            while (it.hasNext()) {
                SelectionKey key = it.next();

                if (key.isAcceptable()) { // 只有SocketServerChannel才会ACCEPT就绪
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = server.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ); // 将SocketChannel也注册到同一个Selector中，复用一个Selector

                    sayHello(socketChannel); // 发送数据给accept到的Socket
                }

                if (key.isReadable()) { // 这里只有SocketChannel才会READ就绪
                    readDataFromSocket(key); // 从Socket中读取数据
                }

                it.remove();
            }

        }
    }

    void readDataFromSocket(SelectionKey selectionKey) throws Exception {
        SocketChannel channel = (SocketChannel) selectionKey.channel();

        int count;

        buffer.clear();

        while ((count = channel.read(buffer)) > 0) {
            buffer.flip();

            while (buffer.hasRemaining()) {
                System.out.print((char)buffer.get());
            }

            buffer.clear();
        }
        System.out.println();

        if (count < 0) {
            channel.close();
        }
    }

    void sayHello(SocketChannel channel) throws Exception {
        buffer.clear();
        buffer.put("Hello, come here!\r\n".getBytes());
        buffer.flip();
        channel.write(buffer);
    }

    public static void main(String[] args) throws Exception {
        new SelectSocketsExample().serve();
    }
}
