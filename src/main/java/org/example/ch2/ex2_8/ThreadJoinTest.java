package org.example.ch2.ex2_8;

/**
 * main 쓰레드가 생성해서 실행시킨 쓰레드가 종료될 때까지 main 쓰레드가 기다려야하는 상황...
 * -> Thread 클래스에서 제공하는 join() 메서드로 해결 가능.. 근데 뭘 해결해????
 */
public class ThreadJoinTest {

    public static void main(String[] args) {
        System.out.println("main() 시작");

        // 쓰레드를 생성
        Thread t = new Thread() {
            public void run() {
                try {
                    // 2초간 중지
                    Thread.sleep(2000);
                    // 쓰레드 종료 메시지
                    System.out.println("MyThread 종료");
                    // 3초간 중지 ... 이건 왜??
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    //
                }
            }
        };

        // 쓰레드를 시작한다.
        System.out.println("MyThread 호출");
        t.start();

        /*
         * join() 메서드 실행
         * - t 쓰레드가 종료될 때까지 main 쓰레드가 기다린다.
         * - join() 메서드가 InterruptedException 발생시키는 것에 주의!
         */
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // main 메서드 종료 메시지
        System.out.println("main() 종료");
    }
}
