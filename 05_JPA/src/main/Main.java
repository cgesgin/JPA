package main;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EmployeeImp;
import entity.Employee;

public class Main {

	public static void main(String args[]) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();

		//
		EmployeeImp employeeDAO = new EmployeeImp(entityManager);
		//
		Employee employee = new Employee();
		employee.setName("John");
		employee.setName("DOE");
		employee.setSalary(1000);
		//
		Employee employee2 = new Employee();
		employee2.setName("John");
		employee2.setName("DOE");
		employee2.setSalary(2000);
		//
		Employee employee3 = new Employee();
		employee3.setName("John");
		employee3.setName("DOE");
		employee3.setSalary(5000);
		//
		employeeDAO.create(employee);
		employeeDAO.create(employee2);
		employeeDAO.create(employee3);
		//
		System.out.println("findAllEmployee");
		employeeDAO.findAllEmployee().forEach(System.out::println);

		System.out.println("findAllEmployeeNamedQuery");
		employeeDAO.findAllEmployeeNamedQuery().forEach(System.out::println);
		

		System.out.println("findAllEmployeeNamedQuerySingleResult");
		System.out.println(employeeDAO.findByidEmployeeNamedQuery());
		System.out.println("End");
	}
}
