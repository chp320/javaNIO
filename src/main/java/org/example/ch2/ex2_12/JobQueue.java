package org.example.ch2.ex2_12;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class JobQueue implements Queue {

    private static final String NAME = "JOB QUEUE";
    private static final Object monitor = new Object();

    private LinkedList jobs = new LinkedList();

    // -----------------------------------------------------------
    // 하나의 객체만을 생성해서 사용할 수 있도록 싱글턴 패턴을 사용한다.
    private static JobQueue instance = new JobQueue();
    private JobQueue() {}

    public static JobQueue getInstance() {
        if(instance == null) {
            synchronized (JobQueue.class) {
                instance = new JobQueue();
            }
        }
        return instance;
    }
    // -----------------------------------------------------------

    @Override
    public String getName() {
        return NAME;
    }

    public LinkedList getLinkedList() {
        return jobs;
    }

    @Override
    public void clear() {
        synchronized (monitor) {
            jobs.clear();
        }
    }

    @Override
    public void put(Object o) {
        synchronized (monitor) {
            jobs.add(o);
            monitor.notify();       // 얘는 왜 하는걸까?? -> 새로운 데이터 추가되면 '큐가 이용할 수 있으므로' 대기중인 큐가 있다면 깨운다... 라는데. 뭔소리야?
        }
    }

    @Override
    public Object pop() throws InterruptedException, NoSuchElementException {
        Object o = null;
        synchronized (monitor) {
            //  더 이상 큐에서 이용할 수 있는 데이터가 없으므로 쓰레드를 대기시킨다.
            if(jobs.isEmpty()) {
                monitor.wait();
            }
            o = jobs.removeFirst();
        }
        if(o == null) {
            throw new NoSuchElementException();
        }
        return o;
    }

    @Override
    public int size() {
        return jobs.size();
    }
}
