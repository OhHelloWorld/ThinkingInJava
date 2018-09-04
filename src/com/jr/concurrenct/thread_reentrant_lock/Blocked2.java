package com.jr.concurrenct.thread_reentrant_lock;

public class Blocked2 implements Runnable {

    BlockedMutex blocked = new BlockedMutex();

    @Override
    public void run() {
        System.out.println("Waiting for f() in BlockedMutex");
        blocked.f();
        System.out.println("Broken out fo blocked call");
    }
}
