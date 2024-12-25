package entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @Column(name = "DepartmentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDateTime startDate;
    private double budget;
    private int administrator;

    public Department(String name, LocalDateTime startDate, double budget, int administrator) {
        this.name = name;
        this.startDate = startDate;
        this.budget = budget;
        this.administrator = administrator;
    }

    public Department() {
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getAdministrator() {
		return administrator;
	}

	public void setAdministrator(int administrator) {
		this.administrator = administrator;
	}

	@Override
	public String toString() {
		return String.format("Department [id=%s, name=%s, startDate=%s, budget=%s, administrator=%s]", id, name,
				startDate, budget, administrator);
	}
    
    
}