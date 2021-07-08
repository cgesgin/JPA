package entity;

import java.util.ArrayList;
import java.util.Date; 
import java.util.List;
import java.util.Map;
 
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entity.embedded.Address;

@Entity
@Table(name = "Employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	@Column(name = "SALARY")
	private int salary;

	@Column(name = "Type")
	@Enumerated(EnumType.STRING)
	private EmployeeType employeeType;

	@Column(name = "START_DATE")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name = "CONTENT")
	@Lob
	private byte[] content;

	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;

	@OneToOne
	@JoinColumn(name = "PARKING_SPACE_ID", unique = true)
	private ParkingSpace parkingSpace;

	@OneToMany
	@JoinColumn(name="EMP_ID")
	private List<Phone> phones = new ArrayList<>();
	
	@ManyToMany
	//@JoinTable(name = "EMP_PR", joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "PR_ID"))
	private List<Project> projects; 

	@Embedded
	//@AttributeOverride(name="zip",column=@Column(name="ZIP"))
	/*@AttributeOverrides(value={@AttributeOverride(name="zip",column=@Column(name="ZIP")),
			@AttributeOverride(name="road",column=@Column(name="ROAD"))})*/
	private Address address;
	
	@ElementCollection
	//@CollectionTable VE @Column tablo ayarlarý
	@CollectionTable(name="EMPLOYEE_EMAIL",joinColumns=@JoinColumn(name="EMPLOYEE_ID"))
	@Column(name="EMAIL_ADDRESS")
	private List<String> emails;
	
	@ElementCollection
	@CollectionTable(name="EMPLOYEE_PHONE",joinColumns=@JoinColumn(name="EMPLOYEE_ID"))
	@MapKeyColumn(name="TYPE")
	@Column(name="PHONE_NUMBER")
	private Map<String, String> phoneNumbers;
	
	public Employee() {
	}

	public Employee(int id, String name, String surname, int salary, EmployeeType employeeType, Date startDate,
			byte[] content, Department department, ParkingSpace parkingSpace) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.employeeType = employeeType;
		this.startDate = startDate;
		this.content = content;
		this.department = department;
		this.parkingSpace = parkingSpace;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<String> getEmails() {
		return emails;
	}
	
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	
	public Map<String, String> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Map<String, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
}
