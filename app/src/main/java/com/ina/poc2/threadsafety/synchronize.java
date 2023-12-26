package com.ina.poc2.threadsafety;

//public class synchronize {
//}

class A {
    synchronized void sum(int n)
    {
        Thread t = Thread.currentThread();
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                    t.getName() + " : " + (n + i));
        }
    }
}

class B extends Thread {
    A a = new A();
    public void run()
    {
        a.sum(10);
    }
}
class Test {
    public static void main(String[] args)
    {
        B b = new B();
        Thread t1 = new Thread(b);
        Thread t2 = new Thread(b);
        t1.setName("Thread B");
        t2.setName("Thread B");
        t1.start();
        t2.start();
    }
}

