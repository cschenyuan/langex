package chenyuan.langex.java.io.e1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简单的socket I/O程序：当有新的socket链接时，就创建一个线程去处理，向socket的output stream回写数据
 * 这是典型的 同步阻塞I/O
 * 缺点：
 * 1.一个线程只能请求一个客户端链接，当链接量大时，服务端开销较大，可能导致服务宕机
 * 2.无法满足高性能、高并发的常见
 * @author chenyuan
 */
public class SimpleSocketServer {

    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("服务已启动, port=" + port);
            Socket socket;
            while (true) {
                socket = server.accept();
                Thread handler = new Thread(new SimpleHandler(socket));
                handler.start();
                System.out.println("新处理线程已启动： " + handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
