package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "positions")
@NamedQueries({
        @NamedQuery(name = "Position.listPositions1", query = "select p  from Position p where p.name like :name and p.salary >= :tu and p.salary <= :den order by p.name"),
        @NamedQuery(name = "Position.listYearsOfExperienceByPosition1", query = "select e.position.id, SUM(YEAR(e.toDate)- YEAR(e.fromDate)) as soNam  from Position p left join p.experiences e where e.candidate.id = :ma  group by e.position.id")
})


@NamedNativeQueries({
   @NamedNativeQuery(name = "Position.listPositions", query = "select *  from [dbo].[positions] p where p.name like :name and p.salary >= :tu and p.salary <= :den order by p.name", resultClass = Position.class),
   @NamedNativeQuery(name = "Position.listYearsOfExperienceByPosition", query = "select e.position_id, SUM(DATEDIFF(year, e.from_date,e.to_date)) as soNam from [dbo].[positions] p left join [dbo].[experiences] e on p.position_id = e.position_id where e.candidate_id = :ma group by e.position_id")
}
)
public class Position implements Serializable {
    @Id
    @Column(name = "position_id",nullable = false,unique = true)
    private String id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "salary",nullable = false)
    private double salary;
    @Column(name = "number",nullable = false)
    private int number;

    @OneToMany(mappedBy = "position")
    private Set<Candidate> candidates;

    @OneToMany(mappedBy = "position")
    private Set<Experience> experiences;

    public Position() {
    }

    public Position(String description, double salary, int number, String name, String id) {
        this.description = description;
        this.salary = salary;
        this.number = number;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Position{" +
                "description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", number=" + number +
                '}';
    }
}
