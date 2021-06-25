package chenyuan.langex.java.io.e1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author chenyuan
 */
public class SimpleClient {

    public static void main(String[] args) {
        String serverIP = "127.0.0.1";
        int port = 8080;
        try (Socket socket = new Socket(serverIP, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            socket.getChannel();
            out.println("QUERY TIME ORDER");
            out.flush();
            System.out.println("发送成功");
            String res = in.readLine();
            System.out.println("服务端返回：" + res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
