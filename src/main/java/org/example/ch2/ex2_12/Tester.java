package org.example.ch2.ex2_12;

/**
 * 앞서 만들 큐, 생성자(Producer), 소비자(Consumer) 를 이용해서 테스트하는 클래스
 * 1) 큐 생성
 * 2) 소비자 3개 생성 & 시작
 * 3) 생성자 1개 생성 & 0.5초 후 생성자 종료 & 0.5초 후 소비자 모두 종료
 */
public class Tester {
    public static void main(String[] args) throws InterruptedException{
        // 큐 생성
        Queue queue = JobQueue.getInstance();

        // 소비자 3개 생성 <- 쓰레드 사용
        Thread con1 = new Thread(new Consumer(queue, "1"));
        Thread con2 = new Thread(new Consumer(queue, "2"));
        Thread con3 = new Thread(new Consumer(queue, "3"));
        con1.start();
        con2.start();
        con3.start();

        // 생성자 1개 생성
        Thread pro = new Thread(new Producer(queue));
        pro.start();    // 시작

        // 0.5초 간 정지
        Thread.sleep(500);
        // 생성자 종료
        pro.interrupt();

        // 0.5초 간 정지
        Thread.sleep(500);
        // 소비자 종료
        con1.interrupt();
        con2.interrupt();
        con3.interrupt();
    }
}
