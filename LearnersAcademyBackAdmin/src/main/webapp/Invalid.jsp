<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
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
		Integer errorCode = Integer.parseInt(request.getParameter("error"));

		if (errorCode == 1) {
			out.println("Invalid User");
		}

		else if (errorCode == 2) {
			out.println("Invalid Credentials");
		}

		else if (errorCode == 3) {
			out.println("Only Admin Users are allowed");
		}
	%>
	<br>
	<br>
	<br>
	<a href="Login.jsp"> <span class="glyphicon glyphicon-log-in"></span>
		LogIn
	</a>

</body>
</html>