package com.zl.leetcode.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Create by zhanglong on 2020/8/25
 */
public class FileCopyUtil {

    /**
     * nio方式
     * @param src
     * @param dist
     */
    public static void copy(String src, String dist) throws IOException {
        FileInputStream fin = new FileInputStream(src);
        // 获取流的通道
        FileChannel fcin = fin.getChannel();

        FileOutputStream fout = new FileOutputStream(dist);
        FileChannel fcout = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            // 从输入通道中读取数据到缓冲区
            int r = fcin.read(buffer);

            if (r == -1) break;

            // 切换读写
            buffer.flip();

            fcout.write(buffer);

            // 清空缓冲区
            buffer.clear();
        }

    }
}
