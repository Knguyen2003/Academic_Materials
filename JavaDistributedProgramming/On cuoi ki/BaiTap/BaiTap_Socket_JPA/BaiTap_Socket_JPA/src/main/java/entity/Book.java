package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



@Entity
@Getter
@Setter
@Table(name = "books")
@Inheritance(strategy = InheritanceType.JOINED)
public class Book implements Serializable {
    @Id
    @Column(name = "ISBN", nullable = false,unique = true)
    protected String ISBN;

    @Column(name = "name", nullable = false)
    //kieu la varchar
//    @Column(columnDefinition = "VARCHAR(255)")
    protected String name;

    @Column(name = "publish_year", nullable = false)
    protected int publishYear;

    @Column(name = "num_of_pages", nullable = false)
    protected int numOfPages;

    @Column(name = "price", nullable = false)
    protected double price;


    //Không aánh xạ được khóa
    @ElementCollection
    @CollectionTable(name = "books_authors", joinColumns = @JoinColumn(name = "ISBN"))
    @Column(name = "author")
    protected Set<String> authors = new HashSet<>();



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    protected Publisher publisher;

    @OneToMany(mappedBy = "book")
    protected Set<Reviews> reviews;

    public Book(String ISBN, String name, int publishYear, int numOfPages, double price, Set<String> authors, Publisher publisher) {
        this.ISBN = ISBN;
        this.name = name;
        this.publishYear = publishYear;
        this.numOfPages = numOfPages;
        this.price = price;
        this.authors = authors;
        this.publisher = publisher;
    }

    public Book(String ISBN) {
        this.ISBN = ISBN;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", publishYear=" + publishYear +
                ", numOfPages=" + numOfPages +
                ", price=" + price +
                ", authors=" + authors +
                ", publisher=" + publisher +
                '}';
    }
}
