package br.com.JV_ConstructionCo.actions;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeCreateForward implements Action {

	@Override
	public String call(HttpServletRequest request, HttpServletResponse response, EntityManager entityManager) {
		// TODO Auto-generated method stub
		return "forward:createEmployee.jsp";
	}

}
