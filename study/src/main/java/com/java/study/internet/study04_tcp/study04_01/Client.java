package com.java.study.internet.study04_tcp.study04_01;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 客户端:
 * 要先启动 服务端   否则会报错
 * 1:建立链接:使用Socket 创建客户端+服务器的地址和端口  -->此时已经连接
 * 2:操作:输入输出操作
 */

public class Client {
    public static void main(String[] args) throws IOException {
        //1:建立链接:使用Socket 创建客户端+服务器的地址和端口
        Socket socket = new Socket("localhost", 9888);
        //2:操作:输入输出操作
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入账号");
        String userName = reader.readLine();
        System.out.println("请输入密码");
        String pwd = reader.readLine();
        String data = "HELLO" + userName + pwd;
        dos.writeUTF(data);
        dos.flush();
        //3:释放资源
        dos.close();
        socket.close();

    }
}
