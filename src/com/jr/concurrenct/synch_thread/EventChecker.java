package com.jr.concurrenct.synch_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventChecker implements Runnable {

    private IntGenerator intGenerator;
    private final int id;

    public EventChecker(IntGenerator intGenerator,int id){
        this.intGenerator = intGenerator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!intGenerator.isCanceled()){
            int val = intGenerator.next();
            if (val % 2 != 0){
                System.out.println(val + " not even");
                intGenerator.cancel();
            }
        }
    }

    public static void test(IntGenerator intGenerator,int count){
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i =0;i<count;i++){
            exec.execute(new EventChecker(intGenerator,i));
        }
    }

    public static void test(IntGenerator intGenerator){
        test(intGenerator,10);
    }
}
