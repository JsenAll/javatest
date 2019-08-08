package com.java.study.internet.study03_udp.study03_03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 多线程 --接受端
 */
public class TalkReceive implements Runnable {
    private DatagramSocket datagramSocket;

     TalkReceive(int port){
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void run() {
        while (true) {
//         * 2:准备容器 封装成DatagramPacket包裹
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
//         * 3:阻塞式接收包裹 receive(DatagramPacket p)
            try {
                datagramSocket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
//         * 4:分析数据
            byte[] datas = packet.getData();
            int len = packet.getLength();

            String data = new String(datas, 0, len);
            System.out.println(Thread.currentThread().getName()+"--->"+data);
            if (data.equals("baibai")) {
                break;
            }
        }
//         * 5:释放资源
        datagramSocket.close();

    }
}
