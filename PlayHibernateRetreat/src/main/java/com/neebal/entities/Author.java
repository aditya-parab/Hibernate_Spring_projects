package com.neebal.entities;

import javax.persistence.*;

@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 20)
    private String name;

    @Column(nullable = true)
    private Integer ratings;

    @Column(nullable = false)
    private Character gender;

    // by default this relationship is Eager, but we CAN set it to LAZY fetching in case we dont want it to query for owned entities every time a owner entity is queried
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) //owned element location SHOULD be cascadeable. all locations should be changed/del if author is cha1nged/del
    private Location location;

    public Author(){

    }

    public Author( String name, Integer ratings, Character gender, Location location) {

        this.name = name;
        this.ratings = ratings;
        this.gender = gender;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
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
