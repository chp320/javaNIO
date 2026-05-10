package com.study.java.ch02;

public class StopThreadTest {
    public static void main(String[] args) {
        System.out.println("# Start StopThreadTest.java");
        StopThread stopThread = new StopThread();
        System.out.println("StopThread 호출 전");
        stopThread.process();
        System.out.println("StopThread 호출 후");
    }
}
