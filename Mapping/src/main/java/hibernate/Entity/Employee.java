package hibernate.Entity;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    private Integer id;

    private String name;

    @ManyToOne
    private Department department;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee(Integer id, String name,Department department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}
    
}

