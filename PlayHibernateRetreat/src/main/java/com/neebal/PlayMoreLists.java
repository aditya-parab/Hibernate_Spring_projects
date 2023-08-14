package com.neebal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayMoreLists {
    public static void main(String[] args) {
        List<Integer> marks = Arrays.asList(4,10,7,4,6,2,1,10,8);
        System.out.println(marks);
        List<Integer> list= new ArrayList<>();

//        marks.forEach(mark->{
//            if(mark%2==0 && mark>4){
//                list.add(mark);
//            }
//        });

       list= marks.stream()
                        .filter(mark->mark%2==0 && mark>4)
                                .collect(Collectors.toList());
        System.out.println(list);

        //return same list but with marks deducted by 1 everywhere

        list = marks.stream()
                .map(mark->mark-1)
                .collect(Collectors.toList());
        System.out.println(list);

        //create new list where u add elements less than 5, squared up


        list = marks.stream()
                .filter(mark->mark%2!=0 && mark<9)
                .map(mark->mark*mark)
                .sorted((a,b)->b-a)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
