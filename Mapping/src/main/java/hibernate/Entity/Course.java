package hibernate.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Course {

	@Id
    private Integer id;

    private String name;

	@ManyToMany(mappedBy = "courses")
    private List<Student> students;
	
	
	public Course(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", students=" + students + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
