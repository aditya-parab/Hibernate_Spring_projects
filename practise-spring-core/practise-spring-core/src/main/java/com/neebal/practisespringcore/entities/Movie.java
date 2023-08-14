package com.neebal.practisespringcore.entities;

public class Movie {
    private String name;
    private String description;
    private int ratings;

    public Movie() {
    }

    public Movie(String name, String description, int ratings) {
        this.name = name;
        this.description = description;
        this.ratings = ratings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ratings=" + ratings +
                '}';
    }
}
