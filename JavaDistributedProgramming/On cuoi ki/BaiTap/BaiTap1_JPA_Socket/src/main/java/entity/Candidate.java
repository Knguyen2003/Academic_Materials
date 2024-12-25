package entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Entity
@Table(name = "candidates")
@NamedQueries({
        @NamedQuery(name = "Candidate.findAll", query = "select c from Candidate c"),
        @NamedQuery(name = "Candidate.listCadidatesByCompanies", query = "select c.id,count(*) as sl from Candidate c join c.experiences e Group by c.id"),

})

@NamedNativeQueries({
        @NamedNativeQuery(name = "Candidate.listCadidatesAndCertificates", query = "Select can.candidate_id , c.certificate_id From  [dbo].[candidates] can LEFT JOIN [dbo].[certificates] c on can.candidate_id = c.candidate_id")
})

public class Candidate implements Serializable {

    @Id
    @Column(name = "candidate_id")
    private String id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "year_of_birth")
    private int yearOfBirth;
    private String gender;
    private String email;
    private String phone;
    private String description;


    @OneToMany(mappedBy = "candidate")
    private Set<Certificate> certificates;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;

    @OneToMany(mappedBy = "candidateNN")
    private Set<Experience> experiences;

    public Candidate() {

    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }

    public Set<Certificate> getCertificates() {
        return certificates;
    }

    public Position getPosition() {
        return position;
    }

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public Candidate(String id,String description,String email, String fullName, String gender,  String phone, int yearOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
