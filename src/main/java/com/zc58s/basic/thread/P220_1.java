package com.zc58s.basic.thread;

/*
 * DesignPattern
 * com.zc58s.basic.thread
 *
 * @author      : fjc.dane@gmail.com
 * @create time : 2020/12/22 13:44
 */
public class P220_1 {

    /**
     * 类锁，类只有一个，所以锁是类级别的，但是也是一个；与P220对应着。
     * <p>
     *
     * </p>
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        MyClass myClass = new MyClass();
        Thread t1 = new Thread(new Processor(myClass));
        Thread t2 = new Thread(new Processor(myClass));

        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        Thread.sleep(1000);
        t2.start();
    }


    static class Processor implements Runnable {

        MyClass myClass;

        public Processor(MyClass myClass) {
            this.myClass = myClass;
        }

        public void run() {
            if ("t1".equals(Thread.currentThread().getName())) {
                myClass.m1();  //用的还是类锁，类锁与对象无关，
            }

            if ("t2".equals(Thread.currentThread().getName())) {
                myClass.m2();
            }
        }
    }

    static class MyClass {

        /**
         * synchronized添加到静态方法中，线程执行此方法的时候会找类锁
         */
        public synchronized static void m1() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m1....");
        }


        /**
         * m2方法不会等m1结束，因为该方法没有被synchronized修饰
         */
        /*
        public static void m2() {
            System.out.println("m2....");
        }

        */

        /**
         * m2会等m1执行结束才能执行，该方法有synchronized，线程执行该代码需要类锁，而类锁只有一个。
         */
        public synchronized static void m2() {
            System.out.println("m2....");
        }
    }
}
