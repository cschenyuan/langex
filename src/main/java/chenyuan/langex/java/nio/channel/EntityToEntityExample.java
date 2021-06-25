package chenyuan.langex.java.nio.channel;

import chenyuan.langex.java.io.e4.ObjectStreamTest;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

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
            byte[] fileBytes = new byte[(int)srcFile.length()]; // 用户缓冲区
            ByteBuffer buffer = ByteBuffer.wrap(fileBytes); // 将用户缓冲区作为channel的缓冲区
            srcFileChannel.read(buffer); // 通过channel读取文件数据到缓冲区
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(fileBytes));
            Object object = ois.readObject(); // 反序列化
            buffer.clear();
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
