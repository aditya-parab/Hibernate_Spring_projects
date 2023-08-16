package com.example.collegemgmt.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="books")
@NamedQueries({
        @NamedQuery(name="queryBookByPriceLessThanEqual",
                    query ="from Book b where b.price <= :price")
})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
        private String title;

    @Column(nullable = false)
    private Integer pages;

    @Column(nullable = true)
    private Double price;

    @OneToMany(mappedBy = "book")
    Set<BookStudent> studentsIssued;

    public Book() {

    }

    public Book(String title, int pages, Double price) {
        this.title = title;
        this.pages = pages;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
