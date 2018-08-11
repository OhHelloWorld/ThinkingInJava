package com.jr.concurrenct.liftoff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MoreBasicThreads {

    public static void main(String[] args) {
//        for(int i = 0; i<5; i++){
//            new Thread(new LiftOff()).start();
//        }
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0;i<5;i++){
            exec.execute(new LiftOff());
        }

        exec.shutdown();

        System.out.println("waiting for liftOff");
    }
}
