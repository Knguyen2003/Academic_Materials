package entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "publishers")
public class Publisher implements Serializable {
    @Id
    @Column(name = "publisher_id", nullable = false, unique = true)
    private String id;

    private String name;

    private String address;

    private String email;

    private String phone;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;


    public Publisher(String id, String name, String address, String email, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public Publisher() {

    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
