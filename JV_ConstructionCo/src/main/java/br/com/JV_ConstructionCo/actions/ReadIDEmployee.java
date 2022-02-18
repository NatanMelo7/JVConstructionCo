package br.com.JV_ConstructionCo.actions;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JV_ConstructionCo.DAO.EmployeeDAO;
import br.com.JV_ConstructionCo.employees.Employee;

public class ReadIDEmployee implements Action {

	@Override
	public String call(HttpServletRequest request, HttpServletResponse response, EntityManager entityManager) {
		EmployeeDAO employeeDAO = new EmployeeDAO(entityManager);

		long idEmployee = Long.parseLong(request.getParameter("id"));

		Employee employee = employeeDAO.findById(idEmployee);

		entityManager.getTransaction().begin();
		request.setAttribute("employee", employee);
		entityManager.getTransaction().commit();

		return "forward:updateEmployee.jsp";
	}

}
