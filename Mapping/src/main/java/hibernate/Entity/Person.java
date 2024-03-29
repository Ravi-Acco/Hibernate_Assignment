package hibernate.Entity;

import jakarta.persistence.*;

@Entity
public class Person {
	@Id
    private Long id;

    private String name;

    @OneToOne//(mappedBy = "person", cascade = CascadeType.ALL)
    private Passport passport;

	public Long getId() {
		return id;
	}

	public Person(Long id, String name, Passport passport) {
		super();
		this.id = id;
		this.name = name;
		this.passport = passport;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", passport=" + passport + "]";
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
}
