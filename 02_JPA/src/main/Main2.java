package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EmployeeImp;
import entity.Department;
import entity.Employee;

public class Main2 {
	
	//OneToMany 

	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();
		EmployeeImp employeeDAO = new EmployeeImp(entityManager);

		Employee employee = new Employee();
		employee.setName("ali");
		employee.setSurname("veli");
		employee.setSalary(5000);
		
		Employee employee2 = new Employee();
		employee2.setName("ali mehmet");
		employee2.setSurname("seli");
		employee2.setSalary(5000);
		
		employeeDAO.create(employee);
		employeeDAO.create(employee2);
		
		Department department = new Department();
		department.setName("Software");
		employeeDAO.createDepartment(department);

		entityManager.getTransaction().begin();
		employee.setDepartment(department);
		employee2.setDepartment(department);
		
		  
		department.getEmployees().add(employee);
		department.getEmployees().add(employee2);
		
		entityManager.getTransaction().commit();
		Department departmentfind = entityManager.find(Department.class, 1);
		departmentfind.getEmployees().forEach(System.out::println);
	}

}