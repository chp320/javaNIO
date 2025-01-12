package org.example.ch2.ex2_5;

public class AdvancedStopThreadTest {
    public static void main(String[] args) {
        System.out.println("# Start AdvancedStopThreadTest.java");

        AdvancedStopThreadTest astt = new AdvancedStopThreadTest();
        astt.process();
    }

    private void process() {
        // AdvancedStopThread 인스턴스를 생성한 후 이 인자를 파라미터로 받는 쓰레드 인스턴스를 생성한 후에 주입시킨다.
        AdvancedStopThread ast = new AdvancedStopThread();
        Thread thread = new Thread(ast);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // AdvancedStopThread 를 정지시킨다.
        thread.interrupt();
    }
}
