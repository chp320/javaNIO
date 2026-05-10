package com.study.java.ch02;

public class ExtendThread extends Thread {
    // run() 을 오버라이딩해서 재정의
    public void run() {
        System.out.println("Thread 클래스 상속");
    }
}
