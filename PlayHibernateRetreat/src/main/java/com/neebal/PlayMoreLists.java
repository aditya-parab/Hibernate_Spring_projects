package com.neebal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayMoreLists {
    public static void main(String[] args) {
        List<Integer> marks = Arrays.asList(4,10,7,4,6,2,1,10,8);

        List<Integer> list= new ArrayList<>();

        marks.forEach(mark->{
            if(mark%2==0 && mark>4){
                list.add(mark);
            }
        });
        System.out.println(list);
    }
}
