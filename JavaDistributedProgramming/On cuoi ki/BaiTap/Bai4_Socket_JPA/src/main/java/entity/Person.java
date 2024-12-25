package entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "people")
@NamedQueries({
        @NamedQuery(name = "Person.getMaintenanceWorkers1", query = "select p from Facility f left join f.maintenances m left join Person p on p.id = m.person.id where f.name like :name and m.cost > 0"),
//        @NamedQuery(name = "Person.updateBy", query = "update Person p set ")
})
//@NamedNativeQueries({
//        @NamedNativeQuery(name = "Person.getMaintenanceWorkers", query = "select p.person_id,p.email,p.full_name,p.phone,p.position from [dbo].[facilities] f join [dbo].[maintenances] m on f.facility_id = m.facility_id join [dbo].[people] p on m.person_id = p.person_id where f.facility_name like :name and m.cost > 0", resultClass = Person.class)
//})

public class Person implements Serializable {
    @Id
    @Column(name = "person_id", nullable = false, unique = true)
    private  String id;
    @Column(name = "full_name", nullable = false)
    private String name;
    private String position;
    private String phone;
    private String email;

    @OneToOne(mappedBy = "person")
    private Department department;

    @OneToMany(mappedBy = "person")
    private Set<Maintenance> maintenances;

    public Person(String id, String name, String position, String phone, String email) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.email = email;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
