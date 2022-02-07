package br.com.JV_ConstructionCo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JV_ConstructionCo.database.DatabaseEmployees;
import br.com.JV_ConstructionCo.employees.Employee;


@WebServlet("/update")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Integer idEmployee = Integer.parseInt(request.getParameter("id"));
		
		DatabaseEmployees db = new DatabaseEmployees();
		Employee employee = db.findById(idEmployee);
		
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("updateEmployee.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Integer idEmployee = Integer.parseInt(request.getParameter("id"));
		
		DatabaseEmployees db = new DatabaseEmployees();
		Employee employee = db.findById(idEmployee);
		
		employee.setFirstName(request.getParameter("fname"));
		employee.setLastName(request.getParameter("lname"));
		employee.setJobRole(request.getParameter("role"));
		employee.setGender(request.getParameter("gender"));
		employee.setSalary(Float.parseFloat(request.getParameter("salary")));
		
		response.sendRedirect("read");
		
	}

}
