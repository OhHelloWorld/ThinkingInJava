package com.jr.concurrenct.thread_needClean;

import java.util.concurrent.TimeUnit;

public class InterruptingIdiom {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Block3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(1999);
        t.interrupt();
    }
}
