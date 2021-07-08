package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EmployeeImp;
import entity.Employee;
import entity.ParkingSpace;

public class Main3 {

	//oneToOne directional kullanýmý
	public static void main(String args[]){
		EntityManagerFactory emp = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager=emp.createEntityManager();
		
		EmployeeImp employeeDAO=new EmployeeImp(entityManager);

		Employee employee = new Employee();
		employee.setName("ali");
		employee.setSurname("veli");
		employee.setSalary(5000);

		ParkingSpace parkingSpace = new ParkingSpace();
		parkingSpace.setFlat(2);
		parkingSpace.setLocation("B-29");
		
		employeeDAO.create(employee);
		employeeDAO.createPakingSpace(parkingSpace);
		entityManager.getTransaction().begin();
		employee.setParkingSpace(parkingSpace);
		parkingSpace.setEmployee(employee);
		entityManager.getTransaction().commit();
		
		ParkingSpace find = entityManager.find(ParkingSpace.class, 1);
		System.out.println(find);
	}
}
