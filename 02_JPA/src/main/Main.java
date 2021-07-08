package main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Department;
import entity.Employee;
import entity.EmployeeType;
import entity.ParkingSpace;
import dao.EmployeeDAO;
import dao.EmployeeImp;

public class Main {

	public static void main(String args[]) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();

		EmployeeImp employeeDAO = new EmployeeImp(entityManager);
		
		byte[] content="content".getBytes();
		
		Department department1=new Department();
		department1.setName("it");
		Department department2=new Department();
		department2.setName("software");

		
		employeeDAO.createDeparment(department1);
		employeeDAO.createDeparment(department2);
		
		
		ParkingSpace parkingSpace = new ParkingSpace();
		parkingSpace.setFlat(-1);
		parkingSpace.setLocation("B-2");
		ParkingSpace parkingSpace2 = new ParkingSpace();
		parkingSpace2.setFlat(-1);
		parkingSpace2.setLocation("B-2");
		
		employeeDAO.createPakingSpace(parkingSpace2);
		employeeDAO.createPakingSpace(parkingSpace);
		
		Employee employee = new Employee(3, "ad2", "soyad", 5000,EmployeeType.FULL_TIME,new Date(),content,department1,parkingSpace);
		Employee employee1 = new Employee(3, "ad2", "soyad", 5000,EmployeeType.FULL_TIME,new Date(),content,department2,parkingSpace2);
		
		System.out.println("insert");
		
		employeeDAO.create(employee);
		employeeDAO.create(employee1);
		
		
		entityManager.close();
		emf.close();
	}
}
