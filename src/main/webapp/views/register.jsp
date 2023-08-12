<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>

<head>
<%@include file="./base.jsp"%>
<title>Customer CRUD | Registration</title>
</head>

<body>
	<div class="container mt-3 mx-5">
		<h5 class="ml-5">Customer Details</h5>

		<form class="container mx-5" action="register" method="POST">

			<div class="row mx-5 my-3">
				<div class="col mr-3">
					<input name="first_name" type="text" class="form-control"
						placeholder="Enter First Name" required />
				</div>
				<div class="col mr-3">
					<input name="last_name" type="text" class="form-control"
						placeholder="Enter Last Name" required />
				</div>
			</div>

			<div class="row mx-5 my-3">
				<div class="col mr-3">
					<input name="street" type="text" class="form-control"
						placeholder="Enter Street" required />
				</div>
				<div class="col mr-3">
					<input name="address" type="text" class="form-control"
						placeholder="Enter Address" required />
				</div>
			</div>
			<div class="row mx-5 my-3">
				<div class="col mr-3">
					<input name="city" type="text" class="form-control"
						placeholder="Enter City" required />
				</div>
				<div class="col mr-3">
					<input name="state" type="text" class="form-control"
						placeholder="Enter State" required />
				</div>
			</div>
			<div class="row mx-5 my-3">
				<div class="col mr-3">
					<input name="email" type="text" class="form-control"
						placeholder="Enter Email" required />
				</div>
				<div class="col mr-3">
					<input name="phone" type="text" class="form-control"
						placeholder="Enter Phone" required />
				</div>
			</div>
			<div class="col mx-auto my-3">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form>
	</div>
</body>

</html>