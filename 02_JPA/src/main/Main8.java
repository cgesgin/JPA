package main;
 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
import dao.EmployeeImp;
import entity.Company;
import entity.Employee;
import entity.embedded.Address;

public class Main8 {

	public static void main(String args[]) {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");

		EntityManager entityManager = emf.createEntityManager();

		EmployeeImp employeeDAO= new EmployeeImp(entityManager);

		Company company = new Company("Eclipse Foundation");

		Address address = new Address("stree", "road", "no1", "city", "zip");

		company.setAddress(address);
		employeeDAO.createCompany(company);
		//
		System.out.println("End");
	}
}
