package main;
 

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
import dao.EmployeeImp;
import entity.Company;
import entity.Employee;
import entity.embedded.Address;

public class Main9 {

	public static void main(String args[]) {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");

		EntityManager entityManager = emf.createEntityManager();

		EmployeeImp employeeDAO= new EmployeeImp(entityManager);

		Employee employee=new Employee();
		employee.setName("John");
		employee.setName("DOE");
		employee.setSalary(5000);
		
		employee.setEmails(Arrays.asList("john@.com", "john.doe@.com", "doe@gmail.com"));
		
		employeeDAO.create(employee);
		//
		System.out.println("End");
	}
}
