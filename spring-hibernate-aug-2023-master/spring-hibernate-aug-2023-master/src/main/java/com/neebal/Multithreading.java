package com.neebal;

public class Multithreading {

    public static void main(String[] args) {
        System.out.println("Good morning");
        new Thread(() -> System.out.println("Good afternoon")).start();
        new Thread(() -> System.out.println("Good night")).start();
    }
}
