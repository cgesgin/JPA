package controller;
 
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entity.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

@ManagedBean
@SessionScoped
public class EmployeeController {
	
	private Employee employee;
	private EmployeeService employeeService;
	private List<Employee> employees;
	
	public EmployeeController() {
		employeeService =new EmployeeServiceImpl();
	}
	
	public void addEmployee(){
		employeeService.save(this.employee);
		employees=employeeService.findAll();
	}
	
	public String updateEmployeeFrom(Employee employee){
		this.employee=employee;
		return "/employee/update";
	}
	
	public String updateEmployee(){
		employeeService.update(this.employee);
		
		return "/employee/addAndDelete";
	}
	
	public void deleteEmployee(int id){
		this.employeeService.remove(id);
		employees=employeeService.findAll();
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public Employee getEmployee() {
		if (this.employee==null) {
			this.employee=new Employee();
		}
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
