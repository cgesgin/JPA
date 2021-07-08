package entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Column(name="NAME")
	private String name;
	
	@OneToMany(mappedBy="department")
	//bidirect ili�ki i�in mappedBy kullan�l�r. B�ylece onetomany ili�kisi sa�lanm�� olur.
	private List<Employee>employees;
	
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
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
