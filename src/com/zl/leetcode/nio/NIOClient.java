package com.zl.leetcode.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Create by zhanglong on 2020/8/25
 */
public class NIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream outputStream = socket.getOutputStream();
        String s = "hello word";
        outputStream.write(s.getBytes());
        outputStream.close();
    }
}
