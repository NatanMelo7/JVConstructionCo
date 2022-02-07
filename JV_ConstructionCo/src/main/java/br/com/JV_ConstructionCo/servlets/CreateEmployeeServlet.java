package br.com.JV_ConstructionCo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JV_ConstructionCo.database.DatabaseEmployees;
import br.com.JV_ConstructionCo.employees.Employee;

/**
 * Servlet implementation class CreateEmployeeServlet
 */
@WebServlet("/create")
public class CreateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = new Employee();
		
		employee.setFirstName(request.getParameter("fname"));
		employee.setLastName(request.getParameter("lname"));
		employee.setJobRole(request.getParameter("role"));
		employee.setGender(request.getParameter("gender"));
		employee.setSalary(Float.parseFloat(request.getParameter("salary")));
		
		DatabaseEmployees.setEmployeesDatabase(employee);
		
		response.sendRedirect("index.jsp");
	}

}
