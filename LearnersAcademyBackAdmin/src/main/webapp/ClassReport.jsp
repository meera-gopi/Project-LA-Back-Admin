<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.la.utility.HibernateSession"%>
<%@ page import="java.util.stream.Collectors"%>
<%@ page import="com.la.model.Subject"%>
<%@ page import="com.la.model.Teacher"%>
<%@ page import="com.la.model.Student"%>
<%@ page import="com.la.model.Classes"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.SessionFactory"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Class Report</title>
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

			String hibernateQuery = "select p from Classes p";
			List<Classes> classList = session1.createQuery(hibernateQuery, Classes.class).getResultList();
	%>

	<div class="container">
		<h2>Class Report</h2>
		<h3>This page shows current classes and times</h3>

		<a href="InsertStudentInfo.jsp">Add students to the class</a> <br>
		<br> <a href="Dashboard.jsp">Go to Dashboard</a> <br>
		<br>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Class_Id</th>
					<th>Class Name</th>
					<th>Subject Name</th>
					<th>Teacher Name</th>
					<th>Start Time</th>
					<th>End Time</th>
					<th>SudentList</th>

				</tr>
			</thead>
			<tbody>

				<%
					for (Classes cls : classList) {
							out.println("<tr>");
							out.println("<td>" + cls.getClass_Id() + "</td>");
							out.println("<td>" + cls.getClass_Name() + "</td>");
							out.println("<td>" + cls.getSub().getSub_Name() + "</td>");
							out.println("<td>" + cls.getTch().getFirst_Name() + " " + cls.getTch().getLast_Name() + "</td>");
							out.println("<td>" + cls.getStart_Time() + "</td>");
							out.println("<td>" + cls.getEnd_Time() + "</td>");
							out.println("<td>" + cls.getStd().stream()
									.map(mapper -> (mapper.getFirst_Name() + " " + mapper.getLast_Name()))
									.collect(Collectors.toList()) + "</td>");
							out.println("</tr>");
						}
				%>

			</tbody>
		</table>
	</div>


	<%
		session1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>


</body>
</html>