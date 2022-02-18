package br.com.JV_ConstructionCo.actions;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {	
	public String call(HttpServletRequest request, HttpServletResponse response, EntityManager entityManager);
}
