package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "maintenances")
public class Maintenance implements Serializable {
    @Id
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    private String description;
    private double cost;


    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @Id
    @JoinColumn(name = "facility_id")
    private Facility facility;

    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @Id
    @JoinColumn(name = "person_id")
    private Person person;

    public Maintenance(LocalDate startDate, LocalDate endDate, String description, double cost) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.cost = cost;
    }

    public Maintenance() {

    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
