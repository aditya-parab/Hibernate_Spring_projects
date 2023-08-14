package com.neebal.practisespringcore.service;

import com.neebal.practisespringcore.entities.Movie;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MovieDetailsService {

    private Map<String, Movie> moviesMap;

    public MovieDetailsService() {
        moviesMap = new HashMap<>();
        this.moviesMap.put("Terminator 2",new Movie("Terminator 2","movie on robots",4));
        this.moviesMap.put("Terminator 2",new Movie("3 Idiots","movie on 3 friends",5));
        this.moviesMap.put("Dhoom",new Movie("Terminator 2","movie on bikes",3));
        this.moviesMap.put("Titanic",new Movie("Titanic","tradegy on ship",4));
        this.moviesMap.put("Avatar",new Movie("Avatar","movie on aliens",4));


    }

    public Map<String, Movie> getMoviesMap(){

        return this.moviesMap;

    }
    public Movie getMovieDetails(String title){

        return this.moviesMap.get(title);

    }


}


