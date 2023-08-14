package com.neebal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayMoreLists {

    public static void main(String[] args) {
        List<Integer> marks = Arrays.asList(4, 10, 7, 4, 6, 2, 1, 10, 8);

         /* List<Integer> m1 = new ArrayList<>();
        marks.forEach(mark -> {
            if (mark % 2 == 0 && mark > 4) {
                m1.add(mark);
            }
        });
        System.out.println(m1); */

        // Create a new List object
        // containing all even marks more than 4 from marks list
        // marks ---> filtering ---> mapping ---> sort---> filtering ---> new list
        // Stream API

        List<Integer> m1 = marks
                .stream()
                .filter(mark -> mark % 2 == 0 && mark > 4)
                .collect(Collectors.toList());
        System.out.println(m1);

        // create a new list object containing all elements
        // from marks list but where each element is deducted by 1
        List<Integer> m2 = marks
                .stream()
                .map(mark -> mark - 1)
                .collect(Collectors.toList());
        System.out.println(m2);

        // create a new list object containing
        // odd elements less than 9 from marks list
        // squared up
        // sorted in descending order
        List<Integer> m3 = marks
                .stream()
                .filter(mark -> mark % 2 != 0 && mark < 9)
                .map(mark -> mark * mark)
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());
        System.out.println(m3);
    }
}
