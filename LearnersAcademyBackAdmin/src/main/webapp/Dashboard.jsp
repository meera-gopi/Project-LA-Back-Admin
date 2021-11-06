<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Learners Academy</title>
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
		String userName;
		if (request.getAttribute("name") == null) {
			userName = (String) session.getAttribute("name");
		} else {
			userName = (String) request.getAttribute("name");
		}
		session.setAttribute("name", userName);
		System.out.println(userName);
		if (userName == null) {
			response.sendRedirect("Invalid.jsp?error=1");
		}
	%>

	<div class="jumbotron">
		<h3>
			Welcome
			<%=userName%></h3>
		<p>Learners Academy Admin Window helps you to view and update
			informations.</p>
		<br>
		<br>
		<p>
			<a href="Logout.jsp"> <span class="glyphicon glyphicon-log-out">
					LogOut</span>
			</a>
		</p>
		<br>
		<br>
		<div class="container">

			<p>Select Links to Navigate to Specified Sections.</p>

			<a href="<%=response.encodeURL("SubjectList.jsp")%>"
				class="link-primary">Subject List</a> <br>
			<br> <a href="TeachersList.jsp" class="link-primary">Teacher
				List</a> <br>
			<br> <a href="StudentsList.jsp" class="link-primary">Student
				List</a> <br>
			<br> <a href="ClassReport.jsp" class="link-primary">Class
				Report</a> <br>
			<br>

		</div>


	</div>


</body>
</html>