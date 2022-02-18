<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 
 <c:url value="/ReadIDEmployee" var="updateEmployeeServlet"></c:url>
<c:url value="/DeleteEmployee" var="deleteEmployeeServlet"></c:url>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#data {
	  font-family: Arial, Helvetica, sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	}
	
	#data td, #data th {
	  border: 1px solid #ddd;
	  padding: 8px;
	}
	
	#data tr:nth-child(even){background-color: #f2f2f2;}
	
	#data tr:hover {background-color: #ddd;}
	
	#data th {
	  padding-top: 12px;
	  padding-bottom: 12px;
	  text-align: left;
	  background-color: #04AA6D;
	  color: white;
	}
</style>
</head>
<body>
	<table>
		<tr id="data">
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gender</th>
			<th>Job Role</th>
			<th>Salary</th>
			<th>Action</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${ databaseEmployees }" var="employees">
			<tr>
				<th>${ employees.firstName }</th> 
				<th>${ employees.lastName }</th>
				<th>${ employees.gender }</th>
				<th>${employees.jobRole }</th>
				<th>${employees.salary }</th>
				<th><a id="link" href="${updateEmployeeServlet}?id=${employees.id}">Edit</a></th>
				<th><a href="${deleteEmployeeServlet}?id=${employees.id}">Delete</a></th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>