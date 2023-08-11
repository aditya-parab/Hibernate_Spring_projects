package com.neebal.entities;




import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50,nullable = false,unique = true)
    private String title;

    @Column(nullable = false)
    private Integer pages;

    @Column(nullable = true)
    private Double price;

    @ManyToOne
    private PublicationHouse publicationHouse;

    public void setPublicationHouse(PublicationHouse publicationHouse) {
        this.publicationHouse = publicationHouse;
    }

    public Book(){
    }

    public Book(String title, Integer pages, Double price) {
        this.title = title;
        this.pages = pages;
        this.price = price;
    }

    public Book(String title, Integer pages, Double price,PublicationHouse publicationHouse) {
        this.title = title;
        this.pages = pages;
        this.price = price;
        this.publicationHouse = publicationHouse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                '}';
    }
}
