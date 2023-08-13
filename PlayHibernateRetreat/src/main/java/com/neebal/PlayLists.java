package com.neebal;

import java.util.Arrays;
import java.util.List;

public class PlayLists {

    public static void main(String[] args) {
        List<Integer> marks = Arrays.asList(4,10,7,4,6,2,1,10,8);


        // print all even marks
        System.out.println("**************Even marks*************");
        for(Integer mark:marks){
            if(mark%2==0)
                System.out.println(mark);
        }

        //print all marks who have scored odd marks more than 3
        System.out.println("**************odd marks more than 3*************");
        for(Integer mark:marks){
            if(mark%2!=0 && mark>3)
                System.out.println(mark);
        }


        //print all marks who have scored odd marks more than 3
        System.out.println("**************odd marks more than 3*************");
        marks.forEach(mark -> {
            if(mark%2!=0 && mark>3){
                System.out.println(mark);
            }
        });



    }
}
