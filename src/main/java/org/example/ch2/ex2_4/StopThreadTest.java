package org.example.ch2.ex2_4;

public class StopThreadTest {
    public static void main(String[] args) {
        System.out.println("# Start StopThreadTest.java");
        StopThread stopThread = new StopThread();
        System.out.println("StopThread 호출 전");
        stopThread.process();
        System.out.println("StopThread 호출 후");
    }
}
