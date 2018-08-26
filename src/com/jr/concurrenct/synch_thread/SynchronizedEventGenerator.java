package com.jr.concurrenct.synch_thread;

public class SynchronizedEventGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EventChecker.test(new SynchronizedEventGenerator());
    }
}
