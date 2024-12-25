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
    @Column(name = "person_id", nullable = false,unique = true)
    private int id;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "professional_title", nullable = false)
    private String professionalTitle;


    @OneToMany(mappedBy = "person")
    private Set<Reviews> reviews;

    public Person() {

    }

    public Person(String email, String professionalTitle, String lastName, int id, String firstName) {
        this.email = email;
        this.professionalTitle = professionalTitle;
        this.lastName = lastName;
        this.id = id;
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", professionalTitle='" + professionalTitle + '\'' +
                '}';
    }
}
