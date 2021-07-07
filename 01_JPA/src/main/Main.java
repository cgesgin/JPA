package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entity.Employee;
import dao.EmployeeDAO;

public class Main {

	public static void main(String args[]) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();

		EmployeeDAO employeeDAO = new EmployeeDAO(entityManager);

		Employee employee = new Employee(1, "Employee1", "Employee1", 1000);
		Employee employee1 = new Employee(2, "Employee2", "Employee2", 5000);
		Employee employee2 = new Employee(3, "Employee3", "Employee3", 10000);

		System.out.println("insert");

		employeeDAO.create(employee);
		employeeDAO.create(employee1);
		employeeDAO.create(employee2);

		System.out.println("---------------------");

		System.out.println("find");

		Employee foundEmployee = employeeDAO.findEmployeeById(2);
		System.out.println(foundEmployee);

		System.out.println("---------------------");

		System.out.println("All Employees");
		employeeDAO.findAllEmployees().forEach(System.out::println);
		
		System.out.println("---------------------");
		
		System.out.println("delete");
		employeeDAO.removeEmployee(2);
		
		System.out.println("---------------------");
		
		System.out.println("update");
		employeeDAO.raiseSalary(1, 3000);

		foundEmployee = employeeDAO.findEmployeeById(1);
		System.out.println(foundEmployee);
		
		System.out.println("---------------------");
		
	}
}
