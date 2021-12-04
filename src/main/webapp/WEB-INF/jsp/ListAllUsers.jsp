<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
	crossorigin="anonymous"></script>
</head>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<a class="navbar-brand" style="display: flex;">Banking App</a>
				</div>
				<div>
					<ul class="navbar-nav me-auto mb-2 mb-lg-0 nav-user">
						<li class="nav-item"><a class="nav-link" href="#"
							style="display: flex;"> <i class="fas fa-shopping-cart"
								style="color: #fff; font-size: 20px;"></i></a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-user-circle"
								style="color: #fff; font-size: 20px;"></i> &nbsp; Hi, <%=session.getAttribute("fullname")%></b>!
						</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href='ViewProfile'>Your Profile</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="Logout">Logout</a>
							</div></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<div class=" mt-5 ml-2 mr-2">
		<h2>
			<center>All Users</center>
		</h2>

		<div class="mb-5 mt-5">
			<a href="AddAccountExistinguser" class="btn btn-primary"> Add
				Account for Existing User </a> <a href="AddAccountNewUser"
				class="btn btn-primary"> Add Account for New User </a>
		</div>
		<div class="mt-3">

			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">#User Code</th>
						<th scope="col">Username</th>
						<th scope="col">Gender</th>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Email</th>
						<th scope="col">#Account Number</th>
						<th scope="col">Balance</th>
						<th scope="col">Account Closed?</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${listUsers}">
						<tr>
							<td scope="row">BANK000${user.idusers}-700-CA00</td>
							<td>${user.username}</td>
							<td>${user.gender}</td>
							<td>${user.fname}</td>
							<td>${user.lastname}</td>
							<td>${user.email}</td>
							<td>CA000${user.idaccounts}000IN</td>
							<td>$${user.balance}</td>
							<td><c:if test="${user.accountclosed == 1}">
					No
				</c:if> <c:if test="${user.accountclosed == 0}">
					Yes
				</c:if></td>
							<td><c:if test="${user.accountclosed == 1}">
									<a href="EditUserAccount/${user.idusers}/${user.idaccounts}"
										class="btn btn-info">Edit User</a>
									<a href="DeactivateAccount/${user.idusers}/${user.idaccounts}"
										class="btn btn-danger">Deactivate Account</a>
								</c:if> <c:if test="${user.accountclosed == 0}">
									<a href="Activate/${user.idusers}/${user.idaccounts}"
										class="btn btn-primary">Activate Account</a>
								</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<a href="Welcome" class="btn btn-dark"> <<--Back to Welcome Page
				</a>
			</div>
		</div>
	</div>
</body>
</html>