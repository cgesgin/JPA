package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Entity.Employee;

public class EmployeeDAO {
	private EntityManager entityManager;

	public EmployeeDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void create(Employee employee) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		this.entityManager.persist(employee);
		transaction.commit();
	}

	public Employee findEmployeeById(int id) {
		return entityManager.find(Employee.class, id);
	}

	public List<Employee> findAllEmployees() {
		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		return query.getResultList();
	}

	public void removeEmployee(int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(findEmployeeById(id));
		transaction.commit();
	}

	public Employee raiseSalary(int id, int raise) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Employee foundEmployee = findEmployeeById(id);
		if (foundEmployee != null) {
			foundEmployee.setSalary(foundEmployee.getSalary() + raise);
		}
		transaction.commit();
		return foundEmployee;
	}
}
