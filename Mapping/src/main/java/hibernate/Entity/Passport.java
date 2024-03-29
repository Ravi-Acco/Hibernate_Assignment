package hibernate.Entity;

import jakarta.persistence.*;

@Entity
public class Passport {
	@Id
    private Long id;

    private String number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Passport(Long id, String number) {
		super();
		this.id = id;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}
	
}
