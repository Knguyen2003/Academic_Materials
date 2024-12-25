package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "experiences")
public class Experience implements Serializable {
    @Id
    @Column(name = "company_name",nullable = false,unique = true)
    private String companyName;
    @Column(name = "from_date",nullable = false)
    private LocalDate fromDate;
    @Column(name = "to_date",nullable = false)
    private LocalDate toDate;
    @Column(name = "description",nullable = false)
    private String description;


    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @Id
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;



    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @Id
    @JoinColumn(name = "position_id")
    private Position position;



    public Experience() {
    }

    public Experience(String companyName, LocalDate fromDate, LocalDate toDate, String description) {
        this.companyName = companyName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "companyName='" + companyName + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", description='" + description + '\'' +
                '}';
    }
}
