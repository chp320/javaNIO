package org.example.ch2.ex2_1;

public class ExtendThread extends Thread {
    // run() 을 오버라이딩해서 재정의
    public void run() {
        System.out.println("Thread 클래스 상속");
    }
}
