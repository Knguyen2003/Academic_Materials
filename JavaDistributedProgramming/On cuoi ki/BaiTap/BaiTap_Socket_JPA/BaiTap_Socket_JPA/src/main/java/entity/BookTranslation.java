package entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "book_translations")
public class BookTranslation extends Book implements Serializable {

    @Column(name = "translate_name", nullable = false)
    private String translateName;

    private String language;

    public BookTranslation(String ISBN, String name, int publishYear, int numOfPages, double price, Set<String> authors, Publisher publisher, String translateName, String language) {
        super(ISBN, name, publishYear, numOfPages, price, authors, publisher);
        this.translateName = translateName;
        this.language = language;
    }

    public BookTranslation(String ISBN, String translateName, String language) {
        super(ISBN);
        this.translateName = translateName;
        this.language = language;
    }

    public BookTranslation(String translateName, String language) {
        this.translateName = translateName;
        this.language = language;
    }

    public BookTranslation() {
    }

    @Override
    public String toString() {
        return "BookTranslation{" +
                "translateName='" + translateName + '\'' +
                ", language='" + language + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", publishYear=" + publishYear +
                ", numOfPages=" + numOfPages +
                ", price=" + price +
//                ", authors=" + authors +
                ", publisher=" + publisher +
                ", reviews=" + reviews +
                '}';
    }
}
