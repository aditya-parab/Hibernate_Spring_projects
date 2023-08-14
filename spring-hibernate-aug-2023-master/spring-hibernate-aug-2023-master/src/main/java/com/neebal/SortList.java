package com.neebal;

import java.util.Arrays;
import java.util.List;

public class SortList {

    public static void main(String[] args) {
        List<Integer> marks = Arrays.asList(4, 10, 7, 4, 6, 2, 1, 10, 8);

        // sort the elements of the list in descending order
        marks.sort((m1, m2) -> m2.compareTo(m1));
        System.out.println(marks);
    }
}
