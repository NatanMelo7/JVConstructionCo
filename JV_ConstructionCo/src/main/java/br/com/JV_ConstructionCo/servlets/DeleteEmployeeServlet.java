package br.com.JV_ConstructionCo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JV_ConstructionCo.database.DatabaseEmployees;

/**
 * Servlet implementation class DeleteEmployeeServlet
 */
@WebServlet("/delete")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Integer idEmployee = Integer.parseInt(request.getParameter("id"));
		
		DatabaseEmployees.deleteEmployee(idEmployee);
		
		response.sendRedirect("read");
	}

}
