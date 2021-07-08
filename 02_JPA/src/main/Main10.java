package main;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EmployeeImp;
import entity.Employee;

public class Main10 {

	public static void main(String args[]) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();

		//
		EmployeeImp employeeDAO = new EmployeeImp(entityManager);
		//
		Employee employee = new Employee();
		employee.setName("John");
		employee.setName("DOE");
		employee.setSalary(5000);
		//
		Map<String, String> phones = new HashMap<>();
		phones.put("HOME", "218");
		phones.put("WORK", "555");
		phones.put("MOBILE", "444");
		//
		employee.setPhoneNumbers(phones);
		employeeDAO.create(employee);
		//
		System.out.println("End");
	}
}
