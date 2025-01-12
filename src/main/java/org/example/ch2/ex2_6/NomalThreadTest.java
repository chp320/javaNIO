package org.example.ch2.ex2_6;

/**
 * 자바에서는 모든 쓰레드가 종료되어야 JVM 이 종료된다.
 * main() 안에서 생성된 Thread 를 생성하고 main 쓰레드는 종료했지만, 5초 뒤 sleep 에서 깨어난 Thread 가 종료하기 전까지 JVM 이 유지된다.
 */
public class NomalThreadTest {

    public static void main(String[] args) {
        // 쓰레드 생성
        Thread t = new Thread() {
            public void run() {
                try {
                    // 5초간 중지
                    Thread.sleep(5000);
                    // 쓰레드 종료 메시지
                    System.out.println("MyThread 종료");
                } catch (Exception e) {
                    //
                }
            }
        };
        // 쓰레드 시작
        t.start();

        // main 메서드 종료 메시지
        System.out.println("main() 종료");
    }
}
