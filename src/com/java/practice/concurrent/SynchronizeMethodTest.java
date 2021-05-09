package com.java.practice.concurrent;

public class SynchronizeMethodTest {

    static class WorkerTask implements Runnable{
        private String resource1 = "Resource1 data";
        DummyClass dummyClass = new DummyClass();
        @Override
        public void run() {
            //call synchronized methods
            try {
                System.out.println(dummyClass.changeDummyResource());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        WorkerTask task = new WorkerTask();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
    }
}

class DummyClass{
    String dummyResource = "Dummy resource value1";

    public synchronized String changeDummyResource() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(10000);
        dummyResource = "dummyResource changed!!";
        return dummyResource;
    }

    public void dummyMethod(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("Dummy method called...");
    }

}
