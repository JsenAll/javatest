package com.java.study.internet.study03_udp.study03_03;

import com.java.study.internet.study03_udp.study03_03.TalkReceive;
import com.java.study.internet.study03_udp.study03_03.TalkSend;

public class Teacher {
    public static void main(String[] args) {
        new Thread(new TalkSend(6666, "localhost", 8888)).start();
        Thread s = new Thread(new TalkReceive(9999));
        s.setName("学生");
        s.start();
    }
}
