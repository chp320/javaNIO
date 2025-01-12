package org.example.ch2.ex2_5;

public class AdvancedStopThread implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is alive ..");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            //
        } finally {
            //
            System.out.println("Thread is dead ..");
        }
    }
}


