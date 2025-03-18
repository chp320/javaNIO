package org.example.ch2.ex2_12;

/**
 * 생성자에 해당하는 클래스로 데이터 생성하는 역할
 * - Runnable 인터페이스를 구현한 구현 클래스이며, 큐에 0부터 값을 1씩 증가시키면서 넣는 기능 수행
 */
public class Producer implements Runnable {

    private Queue queue = null;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // todo
        System.out.println("[ Start Producer.. ]");
        try {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(Integer.toString(i++));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("[ End Producer .. ]");
        }
    }
}
