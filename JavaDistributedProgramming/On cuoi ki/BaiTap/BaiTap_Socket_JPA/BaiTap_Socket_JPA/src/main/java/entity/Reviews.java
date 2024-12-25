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


    @ManyToOne
    @Id
    @JoinColumn(name = "person_id")
    private Person person;


    @ManyToOne
    @Id
    @JoinColumn(name = "ISBN")
    private Book book;


    public Reviews(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public Reviews() {
    }


    @Override
    public String toString() {
        return "Reviews{" +
                "rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
