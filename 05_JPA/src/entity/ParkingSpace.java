package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.eclipse.persistence.jpa.config.Cascade;

@Entity
@Table(name="parking_space")
public class ParkingSpace {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="FLAT")
	private int flat;
	
	@Column(name="LOCATION")
	private String	location;
	
	@OneToOne(mappedBy="parkingSpace",cascade=CascadeType.ALL)
	private Employee employee;
	// Burada 2 tane unidirectional iliski iken.
	//mappedBy eklenerek 
	// OneToOne bi directional iliski oldu.
	// Iliskinin sahibi owning side -> Employee tarafidir
	// Foreign key bilgisi Employee tarafinda yer alir.
	// owning side ise Employee sýnýfýdýr.
	// Inverse Side ParkingSpace tarafidir. burada foreign key bilgisi yer almaz.
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getFlat() {
		return flat;
	}
	
	public void setFlat(int flat) {
		this.flat = flat;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
