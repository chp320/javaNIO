package org.example.ch2.ex2_4;

public class StopThread implements Runnable {
    // 조건문 탈출 목적의 플래그 변수
    private boolean stopped = false;
    @Override
    public void run() {
        while (!stopped) {
            System.out.println("Thread is alive...");

            // 0.5 초간 멈춤 - 부하 경감 목적
            try {
//                Thread.sleep(500);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Thread is dead...");
    }

    // stop() 메소드 호출로 StopThread 가 종료됨
    public void stop() {
        stopped = true;
    }

    public void process() {
        // StopThread 인스턴스 생성 후 해당 인스턴스를 파라미터로 받는 쓰레드 인스턴스 생성 후 start() 호출
        StopThread thread = new StopThread();
        Thread thread1 = new Thread(thread);
        thread1.start();

        try {
            thread1.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // StopThread 정지
        thread.stop();
    }
}
