package chenyuan.langex.java.nio.selector;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yuan on 16/3/17.
 */
public class SimpleSelectorTest {

    public static void main(String[] args) {
        try {
//            example01();
            asynchronousIO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void example01() throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(0x400);
        Socket socket = new Socket("www.baidu.com",80);
        SocketChannel sChannel = socket.getChannel();

        Selector selector =  Selector.open(); //open
        sChannel.configureBlocking(false); // non-blocking channel only supported by Selector
        SelectionKey selectionKey = // registers a channel to Selector
                sChannel.register(selector, SelectionKey.OP_CONNECT);
        selectionKey.attach(buffer); // attaches an object to this key of channel

        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) continue;

            // get all ready channel's key
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isConnectable()) { // determines type of key
                    System.out.println("Socket has ready to connect.");
                }
                keyIterator.remove();
            }
        }
    }

    // An implementation of Asynchronous I/O through Select
    public static void asynchronousIO() throws Exception {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);

        ServerSocket ss = ssc.socket();
        InetSocketAddress address = new InetSocketAddress(9999);
        ss.bind(address);

        Selector selector = Selector.open();
        SelectionKey k = ssc.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int readyChannel = selector.select();
            if (readyChannel == 0) {
                Thread.sleep(1000L);
                continue;
            }

            Set keys = selector.selectedKeys();
            Iterator keyIterator = keys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = (SelectionKey) keyIterator.next();
                if (key == k && key.isConnectable()) {
                    System.out.println("Socket Connected");
                }
                keyIterator.remove();
            }
        }
    }
}
