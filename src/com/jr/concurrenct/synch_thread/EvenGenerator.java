package com.jr.concurrenct.synch_thread;

public class EvenGenerator extends IntGenerator {

    private int currentEvenValue;

    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EventChecker.test(new EvenGenerator());
    }
}
