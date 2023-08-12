package com.neebal.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "publication_houses")
public class PublicationHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date establishmentDate;


    @OneToMany(mappedBy = "publicationHouse",cascade = CascadeType.ALL) // each book has foreign key of publication house
    private Set<Book> books;

    public void setBooks(Set<Book> books) {
        this.books = books;
    }



    public PublicationHouse() {
    }

    public PublicationHouse(String name, Date establishmentDate) {
        this.name = name;
        this.establishmentDate = establishmentDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public Set<Book> getBooks() {
        return books;
    }
}
