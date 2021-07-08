package main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Department;
import entity.Employee;
import entity.EmployeeType;
import entity.ParkingSpace;
import entity.Project;
import dao.EmployeeDAO;
import dao.EmployeeImp;

public class Main5 {

	public static void main(String args[]) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();

		EmployeeImp employeeDAO = new EmployeeImp(entityManager);
		 
		Employee employee = new Employee();
		employee.setName("ali");
		employee.setSurname("veli");
		employee.setSalary(5000);
		
		Employee employee2 = new Employee();
		employee2.setName("veli");
		employee2.setSurname("ali");
		employee2.setSalary(6000);
		 
		employeeDAO.create(employee);
		employeeDAO.create(employee2);
		
		Project project =new Project("HelloWord");
		Project project2 =new Project("HelloWeb");
		
		employeeDAO.createProject(project);
		employeeDAO.createProject(project2);
		
		
		entityManager.getTransaction().begin();
		//
		employee.getProjects().add(project);
		employee.getProjects().add(project2);
		employee2.getProjects().add(project);
		employee2.getProjects().add(project2);
		//		
		entityManager.getTransaction().commit();
		
		System.out.println("End");
	}
}
