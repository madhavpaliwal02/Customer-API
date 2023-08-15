<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="./base.jsp"%>

<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<title>Customer CRUD | Home Page</title>

<script type="text/javascript">
	function deleteCus(id) {
		/* Confirmation Message to be displayed */
		let ans = confirm("Are you sure you want to delete !!!");
		if (ans == true) {
			let ac = document.createElement("a");
			ac.href = `${pageContext.request.contextPath }/delete/` + id;
			ac.click();
			console.log('deleted')
		} else {
			console.log('no deleted')
		}
	}

	function updateCus(id) {
		/* Confirmation Message to be displayed */
		let ac = document.createElement("a");
		ac.href = `${pageContext.request.contextPath }/update/` + id;
		ac.click();
	}
</script>

</head>
<body>
	<div class="container mx-5">

		<div class="container-fluid">
			<a href="${pageContext.request.contextPath }/add"><button
					class="btn btn-primary position-absolute mt-2">Add
					Customer</button> </a>
			<h5 class="text-center position-relative mt-3 my-auto">Customer
				List</h5>
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
				<c:forEach items="${customer }" var="cus">
					<tr>
						<td>${cus.first_name }</td>
						<td>${cus.last_name }</td>
						<td>${cus.address }</td>
						<td>${cus.city }</td>
						<td>${cus.state }</td>
						<td>${cus.email }</td>
						<td>${cus.phone }</td>
						<td><span onclick='updateCus(`${cus.id }`)' href=""> <i
								class="fa-solid fa-user-pen cursor-pointer"
								style="font-size: 20px"> </i>
						</span> <span class="cursor-pointer" onclick='deleteCus(`${cus.id }`)'
							href=""> <i class="fas fa-trash-can text-danger"
								style="font-size: 20px"></i>
						</span></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>