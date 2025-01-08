package org.example.ch2.ex2_2;

/**
 * 쓰레드 구현 방법2 - '합성' 이용
 * - Runnable 인터페이스를 구현한 클래스를 만들고 새로운 Thread 생성 시 앞서 구현한 클래스를 파라미터로 넘기는 방식
 */
public class RunnableThreadTest {
    public static void main(String[] args) {
        // Thread 생성자에 RunnableThread 인스턴스를 파라미터로 전달
        Thread t = new Thread((Runnable) new RunnableThread());
        System.out.println("start() 호출 전");
        t.start();
        System.out.println("start() 호출 후");
    }
}
