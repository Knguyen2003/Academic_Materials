package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "reviews")
public class Reviews implements Serializable {
    @Column(name = "rating", nullable = false)
    private int rating;
    @Column(name = "comment", nullable = false)
    private String comment;


    @ManyToOne()
    @Id
    @JoinColumn(name = "ISBN")
    private Book book;

    @ManyToOne()
    @Id
    @JoinColumn(name = "person_id")
    private Person person;


    public Reviews() {

    }

    public Reviews(String comment, int rating) {

        this.comment = comment;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "comment='" + comment + '\'' +
                ", rating=" + rating +
                '}';
    }
}
