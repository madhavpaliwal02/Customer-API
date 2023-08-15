<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>

<head>
<%@include file="./base.jsp"%>
<title>Customer CRUD | Update</title>
</head>

<body>
	<div class="container mt-3 mx-5">
		<h5 class="ml-5">Customer Details</h5>

		<form class="container mx-5"
			action="${pageContext.request.contextPath }/updating/${customer.id }"
			method="POST">

			<div class="row mx-5 my-3">
				<div class="col mr-3">
					<input name="first_name" type="text" class="form-control"
						value="${customer.first_name }" placeholder="Enter First Name"
						required />
				</div>
				<div class="col mr-3">
					<input name="last_name" type="text" class="form-control"
						value="${customer.last_name }" placeholder="Enter Last Name"
						required />
				</div>
			</div>

			<div class="row mx-5 my-3">
				<div class="col mr-3">
					<input name="street" type="text" class="form-control"
						value="${customer.street }" placeholder="Enter Street" required />
				</div>
				<div class="col mr-3">
					<input name="address" type="text" class="form-control"
						value="${customer.address }" placeholder="Enter Address" required />
				</div>
			</div>

			<div class="row mx-5 my-3">
				<div class="col mr-3">
					<input name="city" type="text" class="form-control"
						value="${customer.city }" placeholder="Enter City" required />
				</div>
				<div class="col mr-3">
					<input name="state" type="text" class="form-control"
						value="${customer.state }" placeholder="Enter State" required />
				</div>
			</div>

			<div class="row mx-5 my-3">
				<div class="col mr-3">
					<input name="email" type="email" class="form-control"
						value="${customer.email }" placeholder="Enter Email" required />
				</div>
				<div class="col mr-3">
					<input name="phone" type="text" class="form-control"
						value="${customer.phone }" placeholder="Enter Phone" required />
				</div>
			</div>

			<div class="col mx-auto my-3">
				<a
					href="${pageContext.request.contextPath }/updating/${customer.id }"><button
						type="submit" class="btn btn-primary">Update</button></a>
			</div>
		</form>
	</div>
</body>

</html>