package com.zemoso.test;

public class MultiThreadSingletonTest {
    public static void main(String[] args) {
        TicketPrintingServletThread thread1, thread2;

        thread1 = new TicketPrintingServletThread();
        thread2 = new TicketPrintingServletThread();

        //create Threads
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        t1.start();
        t2.start();
    }//main
}//class
