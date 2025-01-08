package org.example.ch2.ex2_1;

/**
 * 쓰레드 구현 방법1 - 상속 이용
 * -> 비즈니스 로직이 들어갈 run() 메소드를 오버라이딩해서 재정의함
 */
public class ExtendThreadTest {
    public static void main(String[] args) {
        Thread t = new ExtendThread();
        // start() 를 이용해서 스레드 시작
        // 이후 ExtendThread 의 run() 이 실행되고
        // run() 이 종료되면 바로 ExtendThread 가 소멸됨
        System.out.println("Thread 호출 전");
        t.start();
        System.out.println("Thread 호출 후");
    }
}
