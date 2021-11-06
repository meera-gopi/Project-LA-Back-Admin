<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enter CLass Info</title>
</head>
<body>


	<div class="jumbotron">
		<h1>Add Class For New Subject</h1>
		<p>Learner’s Academy online management system.</p>
	</div>
	<div class="container">
		<form action="insertclass" method="post">

			<div class="form-group">
				<label for="Sub_Name">Subject Name [Available in Subject
					List page]:</label> <input type="text" class="form-control" id="subid"
					name="subname">
			</div>

			<div class="form-group">
				<label for="class_name">Class Name:</label> <input type="text"
					class="form-control" id="clsname" name="clsname">
			</div>
			<br>
			<div class="form-group">
				<label for="Start Time">Start Time:</label> <input type="text"
					class="form-control" id="stime" name="stime"> <label
					for="End Time">End Time:</label> <input type="text"
					class="form-control" id="etime" name="etime">
			</div>

			<br>

			<div class="form-group">
				<label for=" fname">Teacher First Name:</label> <input type="text"
					class="form-control" id="fname" name="fname"> <label
					for=" lname">Teacher Last Name:</label> <input type="text"
					class="form-control" id="lname" name="lname">
			</div>
			<br>
			<button type="submit" class="btn btn-primary">Insert</button>
		</form>
	</div>


</body>
</html>