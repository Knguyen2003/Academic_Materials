package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Entity
@Table(name = "positions")


@NamedQueries({ //JPAQL
        @NamedQuery(name = "Position.findAll", query = "select p from Position p"),
        @NamedQuery(name = "Position.listPositions", query = "Select p From Position p Where p.name like :ten and (p.salary >= :tu and p.salary <= :den) Order by p.name desc"),
//        @NamedQuery(name = "Position.listYearsOfExperienceByPosition", query = "Select e.position_id, DATEDIFF(year,from_date,to_date) as soNamLamviec\n" +
//                "From Experience e\n" +
//                "Where e.candidate_id = 'C101'")

})

@NamedNativeQueries({ //SQL
        @NamedNativeQuery(name = "Position.listYearsOfExperienceByPosition1", query = "Select e.position_id, SUM(DATEDIFF(year,from_date,to_date)) as soNamLamviec From  [dbo].[experiences] e Where e.candidate_id = :id Group by  e.position_id")
})

public class Position implements Serializable {
    @Id
    @Column(name = "position_id")
    private String id;
    private String name;
    private String description;
    private double salary;
    private int number;

    @OneToMany(mappedBy = "position")
    private Set<Candidate> candidates;

    @OneToMany(mappedBy = "positionNN")
    private Set<Experience> experiences;




    public Position() {
    }

    @Override
    public String toString() {
        return "Position{" +
                "number=" + number +
                ", salary=" + salary +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
