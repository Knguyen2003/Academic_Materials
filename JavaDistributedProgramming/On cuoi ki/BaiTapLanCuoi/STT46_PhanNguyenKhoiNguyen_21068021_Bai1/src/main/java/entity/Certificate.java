package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "certificates")
public class Certificate implements Serializable {
    @Id
    @Column(name = "certificate_id",nullable = false,unique = true)
    private String id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "organization",nullable = false)
    private String organization;
    @Column(name = "issue_date",nullable = false)
    private LocalDate issuedDate;

    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;


    public Certificate() {
    }

    public Certificate(String id, String name, String organization, LocalDate issuedDate) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.issuedDate = issuedDate;
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
