package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "people")
public class Person implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false, unique = true)
    private int id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    private String email;
    @Column(name = "professional_title", nullable = false)
    private String professionalTitle;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Set<Reviews> reviews;


    public Person(int id, String lastName, String firstName, String email, String professionalTitle) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.professionalTitle = professionalTitle;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", professionalTitle='" + professionalTitle + '\'' +
                '}';
    }
}
