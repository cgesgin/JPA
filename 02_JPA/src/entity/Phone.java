package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phone {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    
    @Column(name="PHONE_NUMBER")
    private String no;
    
    @Column(name="TYPE")
    private String type;

    public Phone() {
	
    }

    public Phone(String no, String type) {
	
	this.no = no;
	this.type = type;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getNo() {
	return no;
    }

    public void setNo(String no) {
	this.no = no;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    @Override
    public String toString() {
	return "Phone [id=" + id + ", no=" + no + ", type=" + type + "]";
    }
}
