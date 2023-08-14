package com.neebal;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class PlayLists {

    // higher order function
    /* private static void forEach(List<Integer> elements, Consumer<Integer> consumer) {
        for(Integer element: elements) {
            consumer.accept(element);
        }
    } */

    public static void main(String[] args) {
        List<Integer> marks = Arrays.asList(4, 10, 7, 4, 6, 2, 1, 10, 8);

        // print all the even marks scored in the class
        System.out.println("************** Even marks ***************");
        /* forEach(marks, new Consumer<Integer>() {
            @Override
            public void accept(Integer mark) {
                if (mark % 2 == 0) {
                    System.out.println(mark);
                }
            }
        }); */
        // lambda expressions / functions
        // Functional programming
        /* forEach(marks, mark -> {
            // lower order function
            if (mark % 2 == 0) {
                System.out.println(mark);
            }
        }); */
        marks.forEach(mark -> {
            if (mark % 2 == 0) {
                System.out.println(mark);
            }
        });

        /* for(Integer mark : marks) {
            if (mark % 2 == 0) {
                System.out.println(mark);
            }
        } */

        // print all the students who have scored odd marks more than 3
        System.out.println("***** Odd marks more than 3 ********");
        /* forEach(marks, new Consumer<Integer>() {
            @Override
            public void accept(Integer mark) {
                if (mark % 2 != 0 && mark > 3) {
                    System.out.println(mark);
                }
            }
        }); */
        /* forEach(marks, mark -> {
            // lower order function
            if (mark % 2 != 0 && mark > 3) {
                System.out.println(mark);
            }
        }); */
        marks.forEach(mark -> {
            if (mark % 2 != 0 && mark > 3) {
                System.out.println(mark);
            }
        });
        /* for (Integer mark : marks) {
            if (mark % 2 != 0 && mark > 3) {
                System.out.println(mark);
            }
        } */
    }
}
