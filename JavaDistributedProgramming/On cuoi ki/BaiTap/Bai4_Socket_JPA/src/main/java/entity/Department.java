package entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "departments")
public class Department implements Serializable {
    @Id
    @Column(name = "department_id", nullable = false, unique = true)
    private String id;
    @Column(name = "department_name", nullable = false)
    private String name;
    private String location;


    @OneToMany(mappedBy = "department")
    private Set<Facility> facilities;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Person person;


    public Department(String location, String name, String id) {
        this.location = location;
        this.name = name;
        this.id = id;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
