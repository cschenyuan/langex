package chenyuan.langex.java.nio.selector.e1;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyuan
 */
public class SelectorExample {

    public static void main(String[] args) {

        try {
            Selector selector = Selector.open();

            List<SelectionKey> selectionKeys = create100ChannelsAndRegister(selector);

            System.out.println(selector.select(10000));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<SelectionKey> create100ChannelsAndRegister(Selector selector) throws IOException {

        List<SelectionKey> selectionKeys = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            SocketChannel ss = SocketChannel.open();
            ss.configureBlocking(false);
            switch (i % 4) {
                case 0:
                    selectionKeys.add(ss.register(selector, SelectionKey.OP_READ));
                    break;
                case 1:
                    selectionKeys.add(ss.register(selector, SelectionKey.OP_WRITE));
                    break;
                case 2:
                    selectionKeys.add(ss.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE));
                    break;
                case 3:
                    selectionKeys.add(ss.register(selector, SelectionKey.OP_CONNECT));
                    break;
            }
        }

        return selectionKeys;
    }
}
