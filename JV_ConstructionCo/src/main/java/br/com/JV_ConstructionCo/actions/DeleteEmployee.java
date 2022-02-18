package br.com.JV_ConstructionCo.actions;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JV_ConstructionCo.DAO.EmployeeDAO;

public class DeleteEmployee implements Action {

	@Override
	public String call(HttpServletRequest request, HttpServletResponse response, EntityManager entityManager) {
		EmployeeDAO employeeDAO = new EmployeeDAO(entityManager);

		long idEmployee = Long.parseLong(request.getParameter("id"));

		entityManager.getTransaction().begin();
		employeeDAO.removeEmployeeById(idEmployee);
		entityManager.getTransaction().commit();

		return "redirect:ReadEmployee";
	}
}
