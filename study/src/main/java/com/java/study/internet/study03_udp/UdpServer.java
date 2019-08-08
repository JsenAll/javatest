package com.java.study.internet.study03_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP 编程  接收端
 * 1:使用DatagramSocket 指定端口 创建接收端
 * 2:准备容器 封装成DatagramPacket包裹
 * 3:阻塞式接收包裹 receive(DatagramPacket p)
 * 4:分析数据
 * 5:释放资源
 */
public class UdpServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接受方启动中....");
//         * 1:使用DatagramSocket 指定端口 创建接收端
        DatagramSocket datagramSocket = new DatagramSocket(9999);
//         * 2:准备容器 封装成DatagramPacket包裹
        byte[] container = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);
//         * 3:阻塞式接收包裹 receive(DatagramPacket p)
        datagramSocket.receive(packet);
//         * 4:分析数据
        byte[] datas = packet.getData();
        System.out.println(new String(datas, 0, datas.length));
        System.out.println(packet.getLength());
//         * 5:释放资源
        datagramSocket.close();


    }
}
