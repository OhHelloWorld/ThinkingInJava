package com.jr.concurrenct.thread_reentrant_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedMutex {

    private Lock lock = new ReentrantLock();
    public BlockedMutex(){
        lock.lock();
    }

    public void f(){
        try{
            lock.lockInterruptibly();
            System.out.println("lock required in f()");
        }catch (InterruptedException e){
            System.out.println("Interrupted from lock acquisition in f()");
        }
    }
}
