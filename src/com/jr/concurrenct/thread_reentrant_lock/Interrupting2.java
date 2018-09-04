package com.jr.concurrenct.thread_reentrant_lock;

import java.util.concurrent.TimeUnit;

public class Interrupting2 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread  = new Thread(new Blocked2());
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuting t.interrupt()");
        thread.interrupt();
    }
}
