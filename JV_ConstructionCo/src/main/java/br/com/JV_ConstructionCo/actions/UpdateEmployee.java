package br.com.JV_ConstructionCo.actions;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JV_ConstructionCo.DAO.EmployeeDAO;
import br.com.JV_ConstructionCo.employees.Employee;

public class UpdateEmployee implements Action {

	@Override
	public String call(HttpServletRequest request, HttpServletResponse response, EntityManager entityManager) {
		EmployeeDAO employeeDAO = new EmployeeDAO(entityManager);

		long id = Long.parseLong(request.getParameter("id"));

		Employee employee = employeeDAO.findById(id);
		
		entityManager.getTransaction().begin();
		employeeDAO.updateEmployee(employee);
		
		employee.setFirstName(request.getParameter("fname"));
		employee.setLastName(request.getParameter("lname"));
		employee.setJobRole(request.getParameter("role"));
		employee.setGender(request.getParameter("gender"));
		employee.setSalary(Float.parseFloat(request.getParameter("salary")));

		entityManager.getTransaction().commit();
		
		return "redirect:ReadEmployee";
	}

}
