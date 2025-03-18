package org.example.ch2.ex2_12;

/**
 * Runnable 인터페이스를 구현한 구현 클래스로, 큐에서 데이터를 꺼내서 출력
 */
public class Consumer implements Runnable {
    private Queue queue = null;
    private String name = null;

    public Consumer(Queue queue, String index) {
        this.queue = queue;
        this.name = "Consumer-" + index;
    }

    @Override
    public void run() {
        // todo
        System.out.println("[ Start " + name + ".. ]");
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(name + " : " + queue.pop().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("[ End " + name + ".. ]");
        }
    }
}
