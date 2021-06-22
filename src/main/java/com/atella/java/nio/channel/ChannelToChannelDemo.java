package com.atella.java.nio.channel;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by chenyuan on 2017/11/16.
 */
public class ChannelToChannelDemo {

    @Test
    public void testTransferTo() throws IOException {
        String srcFile = "data/foo.txt";
        String destFile = "data/bar.txt";
        RandomAccessFile raf1 = new RandomAccessFile(srcFile, "r");
        RandomAccessFile raf2 = new RandomAccessFile(destFile, "rw");

        FileChannel srcChannel = raf1.getChannel();
        FileChannel destChannel = raf2.getChannel();

        srcChannel.transferTo(0, srcChannel.size(), destChannel);
        destChannel.force(true);

        raf1.close();
        raf2.close();
    }

    @Test
    public void testTransferFrom() throws IOException {
        String srcFile = "data/foo.txt";
        String destFile = "data/bar.txt";
        RandomAccessFile raf1 = new RandomAccessFile(srcFile, "r");
        RandomAccessFile raf2 = new RandomAccessFile(destFile, "rw");

        FileChannel srcChannel = raf1.getChannel();
        FileChannel destChannel = raf2.getChannel();

        destChannel.transferFrom(srcChannel, destChannel.size(), srcChannel.size());
        destChannel.force(true);

        raf1.close();
        raf2.close();
    }

}
