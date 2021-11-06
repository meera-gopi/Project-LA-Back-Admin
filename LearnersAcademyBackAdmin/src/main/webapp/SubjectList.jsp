<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.la.utility.HibernateSession"%>
<%@ page import="com.la.model.Subject"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.SessionFactory"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subject List</title>
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
		out.println(session.getAttribute("name"));
	%>

	<%
		try {

			SessionFactory factory = HibernateSession.getSessionFactory();
			Session session1 = factory.openSession();

			String hibernateQuery = "select p from Subject p";
			List<Subject> subjectList = session1.createQuery(hibernateQuery, Subject.class).getResultList();
	%>

	<div class="container">
		<h2>Subject List</h2>
		<h3>List of all subjects available at Learners Academy</h3>

		<a href="InsertSubject.jsp">Insert new Subject</a> <br>
		<br> <a href="<%=response.encodeURL("InsertClassDetails.jsp")%>">Assign
			Class to the New Subject</a> <br>
		<br> <a href="<%=response.encodeURL("Dashboard.jsp")%>">Go to
			Dashboard</a> <br>
		<br>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Sub_Name</th>
				</tr>
			</thead>
			<tbody>

				<%
					for (Subject sub : subjectList) {
							out.println("<tr>");
							out.println("<td>" + sub.getId() + "</td>");
							out.println("<td>" + sub.getSub_Name() + "</td>");

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