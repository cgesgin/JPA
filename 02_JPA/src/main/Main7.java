package main;
 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
import dao.EmployeeImp;
import entity.Employee;
import entity.embedded.Address;

public class Main7 {

	public static void main(String args[]) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();

		EmployeeImp employeeDAO = new EmployeeImp(entityManager);
		// 
		Employee employee = new Employee();
		employee.setName("ali");
		employee.setSurname("veli");
		employee.setSalary(5000);
		//
		Address address = new Address("stree", "road", "no", "city", "zip");
		employee.setAddress(address);
		//
		employeeDAO.create(employee); 
		//
		System.out.println("End");
	}
}
