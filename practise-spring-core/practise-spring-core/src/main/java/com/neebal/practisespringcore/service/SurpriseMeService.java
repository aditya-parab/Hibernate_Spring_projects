package com.neebal.practisespringcore.service;

import com.neebal.practisespringcore.entities.Movie;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service // by default is singleton
//@Scope("prototype") //For every usage, a new object in sprint container is created
public class SurpriseMeService {

    //Dependency Injection (DI)
    //Inversion of control

    @Autowired // property injections
    MovieDetailsService movieDetailsService;

    private List<String> movieTitles;
    private Random random;


    //constructor
    public  SurpriseMeService(){
        this.movieTitles = Arrays.asList("Terminator 2","3 Idiots","Dhoom","Titanic","Avatar");
        this.random = new Random();
        System.out.println("a spring object of SurpriseMeService is created");

        //avoid this!
        //dependeny injection graph gets completed once all constructors are finished creation
//        System.out.println(movieDetailsService.getMoviesMap());
    }

    @PostConstruct //runs immediately after constructor for SurpriseMeService is created
    public void init(){
        System.out.println(movieDetailsService.getMoviesMap());
    }

    public Movie getMovie(){
        int r = this.random.nextInt(this.movieTitles.size());
        String title= this.movieTitles.get(r);
        return movieDetailsService.getMovieDetails(title);

    }


}
