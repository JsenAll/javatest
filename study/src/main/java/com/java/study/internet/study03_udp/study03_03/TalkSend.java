package com.java.study.internet.study03_udp.study03_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 多线程 发送端
 */
public class TalkSend implements Runnable {
    private  BufferedReader reader;
    private DatagramSocket client;
    private int receivePort;
    private String receiveIp;

    TalkSend(int sendPort, String receiveIp, int receivePort) {
        try {
            client = new DatagramSocket(sendPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
            this.receivePort = receivePort;
            this.receiveIp = receiveIp;
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            //2:准备数据 一定转成字节数组
            String data = null;
            try {
                data = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] datas = data.getBytes();
            //3：封装成DatagramPacket 包裹，需要指定目的地
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                    new InetSocketAddress(this.receiveIp, this.receivePort));
            //4 发送包裹
            try {
                client.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (data.equals("baibai")) {
                break;
            }

        }
        //5:释放资源
        client.close();
    }
}
