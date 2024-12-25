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
public class BookTranslation extends  Book implements Serializable {
    @Column(name = "translate_name", nullable = false)
    private String translateName;
    @Column(name = "language", nullable = false)
    private String language;

    public BookTranslation() {
    }

    public BookTranslation(String language, String translateName) {
        this.language = language;
        this.translateName = translateName;
    }

    public BookTranslation(Set<String> authors, String ISBN, String name, int numOfPages, double price, int publishYear, Publisher publisher, String language, String translateName) {
        super(authors, ISBN, name, numOfPages, price, publishYear, publisher);
        this.language = language;
        this.translateName = translateName;
    }

    @Override
    public String toString() {
        return "BookTranslation{" +
                "language='" + language + '\'' +
                ", translateName='" + translateName + '\'' +
                ", authors=" + authors +
                ", ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", numOfPages=" + numOfPages +
                ", price=" + price +
                ", publisher=" + publisher +
                ", publishYear=" + publishYear +
                '}';
    }
}
