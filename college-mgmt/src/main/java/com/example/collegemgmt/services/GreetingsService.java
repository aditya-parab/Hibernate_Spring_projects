package com.example.collegemgmt.services;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class GreetingsService {

    public String getGreetingByTime(){
        String message;
        LocalTime localTime =  LocalTime.now();

        int hourOfDay = localTime.getHour();
        if(hourOfDay >0 && hourOfDay<12){
            message="Good morning";
        } else if (hourOfDay >=12 && hourOfDay<20) {
            message="Good evening";
        }
        else {
            message = "Good night";
        }
        return message;
    }

}
