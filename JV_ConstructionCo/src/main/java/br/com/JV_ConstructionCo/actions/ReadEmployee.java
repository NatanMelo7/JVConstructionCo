package br.com.JV_ConstructionCo.actions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JV_ConstructionCo.DAO.EmployeeDAO;
import br.com.JV_ConstructionCo.employees.Employee;

public class ReadEmployee implements Action {

	@Override
	public String call(HttpServletRequest request, HttpServletResponse response, EntityManager entityManager) {
		EmployeeDAO employeeDAO = new EmployeeDAO(entityManager);

		entityManager.getTransaction().begin();
		List<Employee> db = employeeDAO.findEmployees();
		entityManager.getTransaction().commit();
		

		request.setAttribute("databaseEmployees", db);

		return "forward:readEmployees.jsp";
	}

}
