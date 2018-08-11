package com.jr.concurrenct.join_thread;

class Sleeper extends Thread{
    private int duration;
    public Sleeper(String name,int sleepTime){
        super(name);
        duration = sleepTime;
        start();
    }
    public void run(){
        try{
            sleep(duration);
        }catch (InterruptedException e){
            System.out.println(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awaked");
    }
}

class Joinner extends Thread{
    private Sleeper sleeper;
    public Joinner(String name,Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }
    public void run(){
        try{
            sleeper.join();
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}

public class Joining {

    public static void main(String[] args) {

        Sleeper sleeper = new Sleeper("Sleepy",1500),
                grumpy = new Sleeper("grumpy",1500);
        Joinner dopey = new Joinner("Dopey",sleeper),
                doc = new Joinner("Doc",grumpy);
        grumpy.interrupt();
    }
}
