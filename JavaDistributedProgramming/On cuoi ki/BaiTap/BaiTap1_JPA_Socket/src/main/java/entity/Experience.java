package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@ToString
@Entity
@Table(name = "experiences")
public class Experience implements Serializable {
    @Id
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "to_date")
    private LocalDate toDate;
    private String description;

    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @Id
    @JoinColumn(name = "position_id")
    private Position positionNN;

    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @Id
    @JoinColumn(name = "candidate_id")
    private Candidate candidateNN;

    public Experience() {
    }

}
