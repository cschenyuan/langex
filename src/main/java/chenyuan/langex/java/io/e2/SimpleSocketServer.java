package chenyuan.langex.java.io.e2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 当有新的socket链接时，从线程池中取一个线程去处理
 * 这是伪异步I/O
 * 缺点：
 * 1.一个线程只能请求一个客户端链接，当链接量大时，服务端开销较大，可能导致服务宕机
 * 2.无法满足高性能、高并发的常见
 * @author chenyuan
 */
public class SimpleSocketServer {

    public static void main(String[] args) {
        int port = 8080;
        SimpleHandlerExecutorPool executorPool = new SimpleHandlerExecutorPool(4, 100);

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("服务已启动, port=" + port);
            Socket socket;
            while (true) {
                socket = server.accept();
                executorPool.execute(new SimpleHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
