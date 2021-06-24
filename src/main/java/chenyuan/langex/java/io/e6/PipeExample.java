package chenyuan.langex.java.io.e6;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by yuan on 16/10/16.
 */
public class PipeExample {

    @Test
    public void testPipe() {
        try {
            final PipedOutputStream output = new PipedOutputStream();
            final PipedInputStream input = new PipedInputStream(output);

            final String message = "some transfered messages";
            Thread writeThread = new Thread(() -> {
                try {
                    output.write(message.getBytes());
                    output.close();
                } catch (IOException ioe) {
                    System.err.println(ioe.getMessage());
                }
            });

            Thread readThread = new Thread(() -> {
                try {
                    byte[] buffer = new byte[0x1];
                    int len;
                    StringBuilder charReceiver = new StringBuilder();
                    while((len = input.read(buffer)) != -1) {
                        charReceiver.append(new String(buffer,0 ,len));
                    }
                    System.out.println(charReceiver.toString());
                } catch (IOException ioe) {
                    System.err.println(ioe.getMessage());
                }
            });

            writeThread.start();
            Thread.sleep(1000L);
            readThread.start();
        } catch (IOException  | InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
