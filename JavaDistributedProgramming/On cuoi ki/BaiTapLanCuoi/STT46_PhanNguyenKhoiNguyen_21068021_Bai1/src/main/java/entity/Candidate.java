package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "candidates")
@NamedQueries({
        @NamedQuery(name = "Candidate.listCadidatesByCompanies1", query = "select c.id , COUNT(c.id) as soCongTy from Candidate c left join c.experiences e group by c.id"),
        @NamedQuery(name = "Candidate.listCadidatesAndCertificates1", query = "select c.id, cer.id from Candidate c left join c.certificates cer")
})


@NamedNativeQueries({
        @NamedNativeQuery(name = "Candidate.listCadidatesByCompanies",query = "select c.candidate_id , COUNT(c.candidate_id) as soCongTy\n" +
                "from [dbo].[candidates] c left join [dbo].[experiences] e on c.candidate_id = e.candidate_id\n" +
                "group by c.candidate_id"),
        @NamedNativeQuery(name = "Candidate.listCadidatesAndCertificates",query = "select c.candidate_id, cer.certificate_id from [dbo].[candidates] c left join [dbo].[certificates] cer on c.candidate_id =cer.candidate_id"),
        @NamedNativeQuery(name = "Candidate.tim",query = "select * from [dbo].[candidates] c where c.candidate_id = 'C101'",resultClass = Candidate.class)
})

public class Candidate implements Serializable {
    @Id
    @Column(name = "candidate_id",nullable = false,unique = true)
    private String id;
    @Column(name = "full_name",nullable = false)
    private String fullName;
    @Column(name = "year_of_birth",nullable = false)
    private int yearOfBirth;
    @Column(name = "gender",nullable = false)
    private String gender;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "phone",nullable = false)
    private String phone;
    @Column(name = "description",nullable = false)
    private String description;


    @OneToMany(mappedBy = "candidate")
    private Set<Certificate> certificates;

    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;


    @OneToMany(mappedBy = "candidate")
    private Set<Experience> experiences;

    public Candidate() {
    }

    public Candidate(String description, String email, String fullName, String gender, String id, String phone, int yearOfBirth) {
        this.description = description;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.id = id;
        this.phone = phone;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
