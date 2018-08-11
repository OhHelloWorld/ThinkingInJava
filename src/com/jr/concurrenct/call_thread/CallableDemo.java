package com.jr.concurrenct.call_thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class TaskWithResult implements Callable<String>{

    private int id;

    public TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "taskWithResult id is " + id;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        List<Future<String>> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            list.add(exec.submit(new TaskWithResult(i)));

        }

        for(Future<String> fs : list){
            System.out.println(fs.get());
        }
    }

}
