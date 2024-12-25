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
//@ToString
@Entity
@Table(name = "certificates")
public class Certificate implements Serializable {
    @Id
    @Column(name = "certificate_id")
    private String id;
    private String name;
    private String organization;
    @Column(name = "issue_date")
    private LocalDate issuedDate;

    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    public Certificate() {
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", organization='" + organization + '\'' +
                ", issuedDate=" + issuedDate +
                '}';
    }
}
