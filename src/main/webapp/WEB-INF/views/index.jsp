<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="./base.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Customer CRUD | Login Page</title>
</head>

<body>
	<div class="mt-4 mx-5">
		<h3>Login Page</h3>


		<form action="/login" method="POST">
			<div class="mb-3">
				<input class="form-control " name="login_id" type="text"
					placeholder="Login ID">
			</div>
			<div class="mb-3">
				<input class="form-control" name="password" type="password"
					placeholder="Password">
			</div>
			<button class="btn btn-primary" type="submit">Submit</button>
		</form>
	</div>
</body>

</html>