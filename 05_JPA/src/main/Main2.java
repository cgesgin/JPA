package main;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EmployeeImp;
import entity.Department;
import entity.Employee;

public class Main2 {

	public static void main(String args[]) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();

		//
		EmployeeImp employeeDAO = new EmployeeImp(entityManager);
		//
		Employee employee = new Employee();
		employee.setName("John");
		employee.setSurname("DOE");
		employee.setSalary(1000);
		//
		Employee employee2 = new Employee();
		employee2.setName("Jane");
		employee2.setSurname("DOE");
		employee2.setSalary(2000);
		//
		Employee employee3 = new Employee();
		employee3.setName("Ahmet");
		employee3.setSurname("Alo");
		employee3.setSalary(5000);
		//
		Department department=new Department();
		department.setName("it");
		
		Department department1=new Department();
		department1.setName("se");
		
		Department department2=new Department();
		department2.setName("javaee");
		//
		employeeDAO.createDeparment(department);
		employeeDAO.createDeparment(department1);
		employeeDAO.createDeparment(department2);
		//
		employee.setDepartment(department);
		employee2.setDepartment(department1);
		employee3.setDepartment(department2);
		//
		employeeDAO.create(employee);
		employeeDAO.create(employee2);
		employeeDAO.create(employee3);
		//		
		System.out.println("------------------Query Test-------------------");
		System.out.println(employeeDAO.employeeQuery());	

		System.out.println("------------------Criteria API Test-------------------");
		employeeDAO.employeeCriteriaApi();
		System.out.println("End");
	}
}
