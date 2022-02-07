package br.com.JV_ConstructionCo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JV_ConstructionCo.database.DatabaseEmployees;
import br.com.JV_ConstructionCo.employees.Employee;


@WebServlet("/read")
public class ReadEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Employee> db = DatabaseEmployees.getDatabase();
		
		request.setAttribute("databaseEmployees", db);
		RequestDispatcher rd = request.getRequestDispatcher("/readEmployees.jsp");
		rd.forward(request, response);
	}

}
