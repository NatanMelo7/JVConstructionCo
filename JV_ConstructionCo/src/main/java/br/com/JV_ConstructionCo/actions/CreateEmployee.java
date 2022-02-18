package br.com.JV_ConstructionCo.actions;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JV_ConstructionCo.DAO.EmployeeDAO;
import br.com.JV_ConstructionCo.employees.Employee;

public class CreateEmployee implements Action {

	@Override
	public String call(HttpServletRequest request, HttpServletResponse response, EntityManager entityManager) {
		Employee employee = new Employee();
		EmployeeDAO employeeDAO = new EmployeeDAO(entityManager);

		employee.setFirstName(request.getParameter("fname"));
		employee.setLastName(request.getParameter("lname"));
		employee.setJobRole(request.getParameter("role"));
		employee.setGender(request.getParameter("gender"));
		employee.setSalary(Float.parseFloat(request.getParameter("salary")));

		entityManager.getTransaction().begin();
		employeeDAO.addEmployee(employee);
		entityManager.getTransaction().commit();

		return "redirect:index.jsp";
	}
}
