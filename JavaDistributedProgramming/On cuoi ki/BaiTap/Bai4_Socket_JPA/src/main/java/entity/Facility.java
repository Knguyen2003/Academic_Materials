package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "facilities")
@NamedQueries({
        @NamedQuery(name = "Facility.updateFacility", query = "update Facility f set f.description = :description, f.price = :price, f.status = :status, f.location = :location where f.id = :id"),
        @NamedQuery(name = "Facility.countMaintenance1", query = "select  f.id, COUNT(f.id) as soLuotBaoTri  from Facility f left join f.maintenances m group by f.id ")
})

@NamedNativeQueries({
        @NamedNativeQuery(name = "Facility.countMaintenance", query = "select f.facility_id, COUNT(f.facility_id) as soLuotBaoTri from [dbo].[facilities] f left join [dbo].[maintenances] m on f.facility_id = m.facility_id group by f.facility_id ")
})


public class Facility implements Serializable {
    @Id
    @Column(name = "facility_id", nullable = false, unique = true)
    private String id;
    @Column(name = "facility_name", nullable = false)
    private String name;
    private String description;
    @Column(name = "purchase_date", nullable = false)
    private LocalDate purchaseDate;
    private double price;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String location;

    public Facility(String id, String name, String description, double price, LocalDate purchaseDate, Status status, String location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.location = location;
    }

    public Facility(String id, String description, double price, Status status, String location) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.status = status;
        this.location = location;
    }

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


    @OneToMany(mappedBy = "facility")
    private Set<Maintenance> maintenances;



    public Facility() {
    }

    @Override
    public String toString() {
        return "Facility{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
