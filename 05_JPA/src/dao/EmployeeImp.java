package dao;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
	
	@Override
	public List<Employee> findAllEmployee() {
		TypedQuery<Employee> list=entityManager.createQuery("select e FrOm Employee e Where e.salary > ?1 or ?2<e.salary",Employee.class).setParameter(1, 2500).setParameter(2, 6100);
		return list.getResultList();
	}
	@Override
	public List<Employee> findAllEmployeeNamedQuery() {
		TypedQuery<Employee> list=entityManager.createNamedQuery("Employee.name", Employee.class);
		return list.getResultList();
	}
	@Override
	public Employee findByidEmployeeNamedQuery() {
		int id=2;
		TypedQuery<Employee> list=entityManager.createNamedQuery("Employee.id", Employee.class).setParameter("id", id);
		return list.getSingleResult();
		//SingleResult ile veri yoksa exception fýrlatýr. getResultList() ile veri yoksa geri bos liste döner.
	}
	
	@Override
	public List<Employee> employeeQuery(){
		// TypedQuery<Employee> query = entityManager
				// .createQuery("Select e from Employee e where e.salary BETWEEN ?1 and
				// ?2 ", Employee.class)
				// .setParameter(1, 4000)
				// .setParameter(2, 5000);
				// ;
				// List<Employee> emplist = query.getResultList();
				//
				// System.out.println("queryEmployee BETWEEN");
				// emplist.forEach(System.out::println);

				// TypedQuery<Employee> query = entityManager.createQuery("Select e from
				// Employee e where e.name LIKE 'sul%' ", Employee.class);
				// List<Employee> emplist = query.getResultList();
				// System.out.println("queryEmployee LIKE");
				// emplist.forEach(System.out::println);

				// TypedQuery<Employee> query = entityManager.createQuery("Select e from
				// Employee e where e.address.city IN('Malatya','Izmir') ",
				// Employee.class);
				// List<Employee> emplist = query.getResultList();
				// System.out.println("queryEmployee IN");
				// emplist.forEach(System.out::println);
				//
				// //SELECT * FROM EmployeeTable e JOIN Address a on e.emp_id = a.id
				// where a.city in('Istanbul','Izmir');

				// TypedQuery<Long> query = entityManager.createQuery("Select
				// SUM(e.salary) from Employee e", Long.class);
				// TypedQuery<Integer> query = entityManager.createQuery("Select
				// MAX(e.salary) from Employee e", Integer.class);
				// TypedQuery<Long> query = entityManager.createQuery("Select
				// COUNT(e.id) from Employee e", Long.class);
				// TypedQuery<Double> query = entityManager.createQuery("Select
				// AVG(e.salary) from Employee e", Double.class);
				// Double result = query.getSingleResult();
				// System.out.println(result);

				// TypedQuery<Object[]> query = entityManager.createQuery("Select
				// e.address.city , AVG(e.salary) from Employee e GROUP BY
				// e.address.city", Object[].class);
				// List<Object[]> emplist = query.getResultList();
				// for(Object[] element : emplist){
				// System.out.println(element [0] + " ," + element[1]);
				// }

				// TypedQuery<Object[]> query = entityManager.createQuery("Select
				// e.address.city , AVG(e.salary) from Employee e GROUP BY
				// e.address.city HAVING AVG(e.salary)> 5000", Object[].class);
				// List<Object[]> emplist = query.getResultList();
				// for(Object[] element : emplist){
				// System.out.println(element [0] + " ," + element[1]);
				// }

				/*
				TypedQuery<Integer> query = entityManager.createQuery("Select e.salary from Employee e ORDER BY e.salary DESC",
						Integer.class);
				List<Integer> emplist = query.getResultList();
				emplist.forEach(System.out::println);*/

		TypedQuery<Employee> list=entityManager.createQuery("SELECT a FROM Employee a WHERE a.department.name IN('it','se')", Employee.class);
		return list.getResultList();
	}

	@Override
	public void employeeCriteriaApi() {
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//
//		CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
//		Root<Employee> root = query.from(Employee.class);
//		query.select(root);
//
//		TypedQuery<Employee> typedQ = entityManager.createQuery(query);
//
//		System.out.println("Criteria API QUERY");
//		typedQ.getResultList().forEach(System.out::println);
		// Select e from Employee e
		
		// ---------------------------------
		
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//
//		CriteriaQuery<String> query = builder.createQuery(String.class);
//		Root<Employee> root = query.from(Employee.class);
//		query.select(root.get("name"));
//
//		TypedQuery<String> typedQ = entityManager.createQuery(query);
//
//		System.out.println("Criteria API QUERY name");
//		typedQ.getResultList().forEach(System.out::println);
		
		// ------------------------------------
		
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Tuple> query = builder.createQuery(Tuple.class);
//		Root<Employee> root = query.from(Employee.class);
//		query.select(
//				builder.tuple( root.get("name") ,root.get("salary"))
//				);
//
//		TypedQuery<Tuple> typedQ = entityManager.createQuery(query);
//
//		System.out.println("Criteria API QUERY tuple");
//		List<Tuple> tupleList = typedQ.getResultList();
//		for(Tuple t : tupleList){
//			System.out.println(t.get(0) +"," + t.get(1));
//		}
		
		//--------------------------------
		
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<String> query = builder.createQuery(String.class);
//		Root<Employee> root = query.from(Employee.class);
//		query.select(
//				root.get("department").get("name")
//				).where(
//				builder.equal(root.get("name"), "John")		
//				);
//
//		TypedQuery<String> typedQ = entityManager.createQuery(query);
//
//		System.out.println("Criteria API QUERY tuple");
//		
//		System.out.println(typedQ.getSingleResult());
		
		//--------------------------------------------------
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
		Root<Employee> root = query.from(Employee.class);
		//query.select(root).where( builder.greaterThan(root.get("salary") , 5000));

		query.select(root).where( builder.between(root.get("salary"), 
				 builder.parameter(Integer.class, "lowSalary"), 
				 builder.parameter(Integer.class, "highSalary")
				));
		
		TypedQuery<Employee> typedQ = entityManager.createQuery(query)
				.setParameter("lowSalary", 4500).
				setParameter("highSalary", 5000);

		System.out.println("Criteria API between");
		typedQ.getResultList().forEach(System.out::println);
		
	}
}
