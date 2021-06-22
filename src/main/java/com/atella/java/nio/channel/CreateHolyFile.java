package com.atella.java.nio.channel;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by chenyuan on 2017/11/8.
 */
public class CreateHolyFile {

    public static void putData(int position,ByteBuffer buffer,FileChannel channel)
            throws IOException {

        String data = "this is at position " + position;
        buffer.clear();
        buffer.put(data.getBytes());
        buffer.flip();
        channel.position(position);
        channel.write(buffer);
    }

    public static void main(String[] args) throws IOException {

        File tempFile = File.createTempFile("holy_file-", ".txt");
        RandomAccessFile raf = new RandomAccessFile(tempFile, "rw");
        FileChannel channel = raf.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(100);
        putData(0, buffer, channel);
        putData(0x10000, buffer, channel);
        putData(0x50000, buffer, channel);

        System.out.println("File: " + tempFile.getAbsolutePath()
                + " size: " + channel.size());

        channel.close();
        raf.close();

    }

}
