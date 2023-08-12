<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<%@include file="./base.jsp"%>
<title>Customer CRUD | Home Page</title>
</head>
<body>
	<div class="container mx-5">

		<div class="container-fluid">
			<span><a class="text-left btn btn-primary"
				href="${pageContext.request.contextPath }/add"> Add Customer </a> </span> <span
				class="text-center">
				<h5>Customer List</h5>
			</span>
		</div>

		<!-- Table -->
		<table class="table table-hover text-center mt-3 mx-5">
			<thead>
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Address</th>
					<th scope="col">City</th>
					<th scope="col">State</th>
					<th scope="col">Email</th>
					<th scope="col">Phone</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cutomer }" var="cus">
					<tr>
						<td>${cus.first_name }</td>
						<td>${cus.last_name }</td>
						<td>${cus.address }</td>
						<td>${cus.city }</td>
						<td>${cus.state }</td>
						<td>${cus.email }</td>
						<td>${cus.phone }</td>
						<td><span href=""> <i
								class="fas fa-trash-can text-danger" style="font-size: 25px">
							</i>
						</span> <span> <i class="fas fa-trash-can text-danger"
								style="font-size: 25px"></i>
						</span></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>