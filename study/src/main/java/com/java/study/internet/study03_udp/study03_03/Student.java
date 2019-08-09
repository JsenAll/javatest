package com.java.study.internet.study03_udp.study03_03;

public class Student {
    public static void main(String[] args) {
        Thread s = new Thread(new TalkReceive(8888));
        s.setName("老师");
        s.start();
        new Thread(new TalkSend(7777, "localhost", 9999)).start();
    }
}
