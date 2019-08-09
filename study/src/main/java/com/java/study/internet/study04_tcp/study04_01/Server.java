package com.java.study.internet.study04_tcp.study04_01;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器
 * 1:指定端口 使用ServerSocket 创建服务器 想连接这台服务器 就要通过这个端口
 * 2:阻塞式等待连接 accept  有客户端连接 就会获得这个客户端
 * 3:操作
 */
public class Server {
    public static void main(String[] args) throws Exception {
        //1:指定端口 使用ServerSocket 创建服务器 想连接这台服务器 就要通过这个端口
        ServerSocket serverSocket = new ServerSocket(9888);
        //2:阻塞式等待连接 accept  有客户端连接 就会获得这个客户端
        Socket socket = serverSocket.accept();
        //3:操作
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        String data = dis.readUTF();
        System.out.println(data);
        System.out.println("建立链接");
        dis.close();
//        socket.close();
    }
}
