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
    @Column(name = "publisher_id", nullable = false,unique = true)
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> book;

    public Publisher(String address, String phone, String name, String id, String email) {
        this.address = address;
        this.phone = phone;
        this.name = name;
        this.id = id;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "address='" + address + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Publisher() {
    }
}
