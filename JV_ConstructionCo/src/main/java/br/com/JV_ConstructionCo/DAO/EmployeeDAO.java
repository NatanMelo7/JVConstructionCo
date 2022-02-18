package br.com.JV_ConstructionCo.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.JV_ConstructionCo.employees.Employee;

public class EmployeeDAO {
	EntityManager entityManager;
	
	public EmployeeDAO(EntityManager eManager) {
		this.entityManager = eManager;
	}
	
	public void addEmployee(Employee employee) {
		this.entityManager.persist(employee);
	}
	
	public void updateEmployee(Employee employee) {
		this.entityManager.merge(employee);
	}
	
	public void removeEmployee(Employee employee) {
		this.entityManager.merge(employee);
		this.entityManager.remove(employee);
	}
	
	public void removeEmployeeById(long id) {
		Employee employee = this.entityManager.find(Employee.class, id);
		this.entityManager.merge(employee);
		this.entityManager.remove(employee);
	}
	
	public Employee findById(Long id) {
		return this.entityManager.find(Employee.class, id);
	}
	
	public List<Employee> findEmployees(){
		String JPQL = "SELECT e FROM Employee e";
		return this.entityManager.createQuery(JPQL, Employee.class).getResultList();
	}
	
	public List<Employee> findEmployeesByName(String employeeName){
		String JPQL = "SELECT e FROM Employee e WHERE p.nome = :name";
		return this.entityManager.createQuery(JPQL, Employee.class)
				.setParameter("name", employeeName)
				.getResultList();
	}
	
	
	
	
}
