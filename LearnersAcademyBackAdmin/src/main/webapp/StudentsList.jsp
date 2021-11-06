<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.la.utility.HibernateSession"%>
<%@ page import="com.la.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.SessionFactory"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Students List</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


	<%
		try {

			SessionFactory factory = HibernateSession.getSessionFactory();
			Session session1 = factory.openSession();

			String hibernateQuery = "select p from Student p";
			List<Student> studentsList = session1.createQuery(hibernateQuery, Student.class).getResultList();
			session1.close();
	%>

	<div class="container">
		<h2>Students List</h2>
		<h3>List of all students studying at Learners Academy</h3>

		<a href="InsertStudentInfo.jsp">Add new Student Info</a> <br>
		<br> <a href="Dashboard.jsp">Go to Dashboard</a> <br>
		<br>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Full Name</th>
					<th>Class Id</th>
				</tr>
			</thead>
			<tbody>

				<%
					for (Student st : studentsList) {
							out.println("<tr>");
							out.println("<td>" + st.getId() + "</td>");
							out.println("<td>" + st.getFirst_Name() + " " + st.getLast_Name() + "</td>");
							out.println("<td>" + st.getCls().getClass_Id() + "</td>");
							out.println("</tr>");
						}
				%>

			</tbody>
		</table>
	</div>


	<%
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>

</body>
</html>