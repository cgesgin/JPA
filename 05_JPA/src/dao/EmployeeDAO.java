package dao;

import java.util.List;

import entity.Company;
import entity.Department;
import entity.Employee;
import entity.ParkingSpace;
import entity.Phone;
import entity.Project;

public interface EmployeeDAO {

	public void create(Employee employee);
	public void createDeparment(Department department);
	public void createPakingSpace(ParkingSpace parkingSpace);	
	public void createDepartment(Department department);	
	public void createPhone(Phone phone);	
	public void createProject(Project project);	
	public void createCompany(Company company);
	public List<Employee> findAllEmployee();
	public List<Employee> findAllEmployeeNamedQuery();
	public Employee findByidEmployeeNamedQuery();	
	public List<Employee> employeeQuery();	
	public void employeeCriteriaApi();
	
}
