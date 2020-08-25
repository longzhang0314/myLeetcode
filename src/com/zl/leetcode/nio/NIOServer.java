package com.zl.leetcode.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Create by zhanglong on 2020/8/25
 */
public class NIOServer {

    public static void main(String[] args) throws IOException {
        // 创建选择器
        Selector selector = Selector.open();
        // ServerChannel
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        // 非阻塞，否则使用选择器没有意义
        ssChannel.configureBlocking(false);
        // 通道注册到选择器 监听事件
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        ServerSocket serverSocket = ssChannel.socket();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);
        serverSocket.bind(address);

        // 服务器需要一直监听是否有事件到达
        while (true) {
            // 监听事件, 一直阻塞直到有至少一个事件到达
            selector.select();
            // 获取到达的事件
            Set<SelectionKey> keys = selector.selectedKeys();
            // 使用迭代器，方便处理不断删除的情况
            Iterator<SelectionKey> keyIterator = keys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel ssChannel1 = (ServerSocketChannel) key.channel();
                    // 服务器为每个新连接创建一个SocketChannel
                    SocketChannel sChannel = ssChannel1.accept();
                    sChannel.configureBlocking(false);
                    // 这个新连接主要用于从客户端读取数据
                    sChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    SocketChannel sChannel = (SocketChannel) key.channel();
                    System.out.println(readDataFromSocketChannel(sChannel));
                    sChannel.close();
                }
                keyIterator.remove();
            }
        }
    }

    // 读取通道中的数据
    private static String readDataFromSocketChannel(SocketChannel sChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder data = new StringBuilder();

        while (true) {
            buffer.clear();
            int n = sChannel.read(buffer);
            if (n == -1) break;
            buffer.flip();
            int limit = buffer.limit();
            char[] dst = new char[limit];
            for (int i = 0; i < limit; i++) {
                dst[i] = (char) buffer.get(i);
            }
            data.append(dst);
            buffer.clear();
        }

        return data.toString();
    }
}
