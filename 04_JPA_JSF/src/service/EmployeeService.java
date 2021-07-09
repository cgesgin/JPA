package service;

import java.util.List;
 

import entity.Employee; 

public interface EmployeeService {

	public Employee save(Employee employee);

	public Employee findById(int id);

	public List<Employee> findAll();

	public void remove(int id);
	
	public void update(Employee employee);

}
