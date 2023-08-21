package com.neebal.collegemgmt.services;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class GreetingService {
    public String getGreeting() {
        LocalTime localTime = LocalTime.now();
        int hourOfDay = localTime.getHour();
        String message;
        if(hourOfDay > 0 && hourOfDay < 12){
            message = "Good morning";
        } else if (hourOfDay >= 12 && hourOfDay < 16) {
            message = "Good afternoon";
        }
        else {
            message = "Good evening";
        }
        return message;
    }
}
