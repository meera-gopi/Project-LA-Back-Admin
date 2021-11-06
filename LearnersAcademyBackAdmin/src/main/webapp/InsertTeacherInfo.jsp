<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div class="jumbotron">
		<h1>Learners Academy</h1>
		<p>Learner’s Academy online management system.</p>
	</div>
	<div class="container">
		<form action="insertteacher" method="post">

			<div class="form-group">
				<label for="first_name">First Name:</label> <input type="text"
					class="form-control" id="fname" name="fname">
			</div>

			<div class="form-group">
				<label for="last_name">Last Name:</label> <input type="text"
					class="form-control" id="lname" name="lname">
			</div>

			<button type="submit" class="btn btn-primary">Insert</button>
		</form>
	</div>


</body>
</html>