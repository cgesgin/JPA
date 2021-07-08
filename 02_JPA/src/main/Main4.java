package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EmployeeImp;
import entity.Employee;
import entity.Phone;

public class Main4 {

	public static void main(String args[]){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();

		EmployeeImp employeeDAO = new EmployeeImp(entityManager);
		
		//sample data
		Employee employee = new Employee();
		employee.setName("ali");
		employee.setSurname("veli");
		employee.setSalary(5000);
		 
		//sample data
		Phone phone=new Phone("555","MOBILE");
		Phone phone2=new Phone("444","HOME");
		Phone phone3=new Phone("333","HOME");
		
		employee.getPhones().add(phone);
		employee.getPhones().add(phone2);
	
		//save
		
		employeeDAO.createPhone(phone);
		employeeDAO.createPhone(phone2);
		employeeDAO.createPhone(phone3);
		
		employeeDAO.create(employee);
		
		
		//
		System.out.println("end");
	}
}
