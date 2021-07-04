package chenyuan.langex.java.io.e1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @author chenyuan
 */
public class SimpleHandler implements Runnable {

    private Socket socket;

    public SimpleHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            PrintWriter out = new PrintWriter(this.socket.getOutputStream())
        ) {
            String body;
            String currentTime;
            while (true) {
                body = in.readLine();
                if (body == null) {
                    break;
                }
                System.out.println("接收到： " + body);
                currentTime = "QUERY TIME ORDER".trim().equalsIgnoreCase(body) ? new Date().toString() : "BAD ORDER";
                out.println(currentTime);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (this.socket != null) {
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                this.socket = null;
            }
        }
        System.out.println("结束处理");
    }
}

