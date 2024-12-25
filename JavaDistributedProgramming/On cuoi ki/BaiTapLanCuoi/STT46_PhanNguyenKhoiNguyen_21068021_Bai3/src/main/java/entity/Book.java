package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "books")
public class Book implements Serializable {
    @Id
    @Column(name = "ISBN",nullable = false,unique = true)
    protected String ISBN;
    @Column(name = "name",nullable = false)
    protected String name;
    @Column(name = "publish_year",nullable = false)
    protected int publishYear;
    @Column(name = "num_of_pages",nullable = false)
    protected int numOfPages;
    @Column(name = "price",nullable = false)
    protected double price;

    @ElementCollection
    @CollectionTable(name = "books_authors", joinColumns = @JoinColumn(name = "ISBN"))
    @Column(name = "author", nullable = false)
    protected Set<String> authors;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    protected Publisher publisher;



    @OneToMany(mappedBy = "book")
    private Set<Reviews> reviews;


    public Book(Set<String> authors, String ISBN, String name, int numOfPages, double price, int publishYear, Publisher publisher) {
        this.authors = authors;
        this.ISBN = ISBN;
        this.name = name;
        this.numOfPages = numOfPages;
        this.price = price;
        this.publishYear = publishYear;
        this.publisher = publisher;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors=" + authors +
                ", ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", publishYear=" + publishYear +
                ", numOfPages=" + numOfPages +
                ", price=" + price +
                ", publisher=" + publisher +
                '}';
    }
}
