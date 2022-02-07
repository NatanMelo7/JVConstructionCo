package br.com.JV_ConstructionCo.database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.JV_ConstructionCo.employees.Employee;

public class DatabaseEmployees {
	private static List<Employee> database = new ArrayList<Employee>();
	private static Integer idEmployee = 0;

	public static List<Employee> getDatabase() {
		return database;
	}

	public static void setEmployeesDatabase(Employee employee) {
		employee.setId(DatabaseEmployees.idEmployee++);
		DatabaseEmployees.database.add(employee);
	}

	public Employee findById(Integer id) {
		for (Employee employee : database) {
			if(employee.getId() == id)
				return employee;
		}
		return null;
	}

	public static void deleteEmployee(Integer id) {
		Iterator<Employee> iterator = database.iterator();
		
		while(iterator.hasNext()) {
			Employee employee = iterator.next();
			
			if(employee.getId() == id) {
				iterator.remove();
			}
		}
	}
}
