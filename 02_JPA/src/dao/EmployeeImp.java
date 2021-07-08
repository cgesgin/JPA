package dao;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Company;
import entity.Department;
import entity.Employee;
import entity.ParkingSpace;
import entity.Phone;
import entity.Project;

public class EmployeeImp implements EmployeeDAO{

	private EntityManager entityManager; 
	
	public EmployeeImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void create(Employee employee) {
		//pragmatic transaction
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		this.entityManager.persist(employee);
		transaction.commit();
	}

	@Override
	public void createDeparment(Department department) {
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		this.entityManager.persist(department);
		transaction.commit();
		
	}

	@Override
	public void createPakingSpace(ParkingSpace parkingSpace) {
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		this.entityManager.persist(parkingSpace);
		transaction.commit();
		
	}

	@Override
	public void createDepartment(Department department) {
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		this.entityManager.persist(department);
		transaction.commit();
	}

	@Override
	public void createPhone(Phone phone) {
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		this.entityManager.persist(phone);
		transaction.commit();
	}

	@Override
	public void createProject(Project project) {
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		this.entityManager.persist(project);
		transaction.commit();
		
	}

	@Override
	public void createCompany(Company company) {
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		this.entityManager.persist(company);
		transaction.commit();
	}
}
