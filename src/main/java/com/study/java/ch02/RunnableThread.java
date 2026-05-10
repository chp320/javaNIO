package com.study.java.ch02;

public class RunnableThread implements Runnable {

    // run() 을 오버라이딩해서 재정의
    @Override
    public void run() {
        System.out.println("Runnable 인터페이스 구현");
    }
}
