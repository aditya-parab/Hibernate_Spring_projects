package com.neebal.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="authors")
public class Author extends Person{


    @Column(nullable = true)
    private Integer ratings;



    // by default this relationship is Eager, but we CAN set it to LAZY fetching in case we dont want it to query for owned entities every time a owner entity is queried
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) //owned element location SHOULD be cascadeable. all locations should be changed/del if author is cha1nged/del
    private Location location;

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @ManyToMany
    private Set<Book> books;

    public Author(){

    }

    public Author( String name, Integer ratings, Character gender, Location location) {
        super(name,gender);
//        this.name = name;
        this.ratings = ratings;
//        this.gender = gender;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }



    public Integer getRatings() {
        return ratings;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }



    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ratings=" + ratings +
                ", gender=" + gender +
                ", location=" + location +
                '}';
    }
}
