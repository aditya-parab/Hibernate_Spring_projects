package com.neebal;

public class Multithreading {

    public static void main(String[] args) {
        System.out.println("main = Good morning"); //main thread

//        Thread t1 =    new Thread(){
//            @Override
//            public void run(){
//                System.out.println("t1 = Good evening");
//            }
//        };
//
//
//
//        Thread t2 =    new Thread(){
//            @Override
//            public void run(){
//                System.out.println("t2 = Good night");
//            }
//        };
//        t1.start();
//        t2.start();

        new Thread(() -> System.out.println("Good evening")).start();

        new Thread(() -> System.out.println("Good night")).start();


    }
}
