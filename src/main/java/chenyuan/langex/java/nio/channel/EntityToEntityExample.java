package chenyuan.langex.java.nio.channel;

import chenyuan.langex.java.io.e4.ObjectStreamTest;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;

/**
 * @author chenyuan
 */
public class EntityToEntityExample {

    private static final String DIR = "src/main/java/"
            + EntityToEntityExample.class.getPackage().getName().replaceAll("\\.", "/");

    public static void main(String[] args) {
        FileToOthers();
    }

    /**
     * FileChannel.transferTo()
     * data.txt -> others entity
     */
    static void FileToOthers() {
        try (RandomAccessFile srcFile = new RandomAccessFile(DIR+"/object.d", "r");
             FileChannel srcFileChannel = srcFile.getChannel()
        ) {

            // To File, 全封不动复制，中间无任何处理过程
            RandomAccessFile destFile = new RandomAccessFile(DIR + "/data1.txt", "r");
            FileChannel destFileChannel = destFile.getChannel();
            srcFileChannel.transferTo(0, srcFile.length(), destFileChannel);
            destFileChannel.close();

            // reset position
            srcFileChannel.position(0);

            // To Socket
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(8080));
            srcFileChannel.transferTo(0, srcFile.length(), socketChannel);
            socketChannel.close();

            srcFileChannel.position(0);

            // TO UDP
            DatagramChannel udpChannel = DatagramChannel.open();
            udpChannel.connect(new InetSocketAddress(8080));
            srcFileChannel.transferTo(0, srcFile.length(), socketChannel);
            udpChannel.close();

            srcFileChannel.position(0);

            // TO JavaObject
            // 创建一个输入流(sun.nio.ch.ChannelInputStream)，从通道中读取数据
            InputStream ins = Channels.newInputStream(srcFileChannel);
            ObjectInputStream ois = new ObjectInputStream(ins);
            Object object = ois.readObject(); // 反序列化
            ois.close();
            System.out.println(object.getClass().getSimpleName() + ": " + object);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void SocketToOthers() {

    }

    static void UDPToOthers() {

    }

    static void JavaObjectToOthers() {

    }

}
