package com.neebal.practisespringcore.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SurpriseMeService {

    private List<String> movieTitles;
    private Random random;


    //constructor
    public SurpriseMeService(){
        this.movieTitles = Arrays.asList("Terminator 2","3 Idiots","Dhoom","Titanic","Avatar");
        this.random = new Random();
    }

    public String getMovie(){
        int r = this.random.nextInt(this.movieTitles.size());
        return this.movieTitles.get(r);
    }


}
