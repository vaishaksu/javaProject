<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIEW ALL Users</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<title>View Your profile</title>
</head>
<body>
	WELCOME
	<b><%=session.getAttribute("fullname")%></b>!

	<a href="AddAccountExistinguser" class="btn btn-primary"> Add
		Account for Existing User </a>
	<a href="AddAccountNewUser" class="btn btn-primary"> Add Account
		for New User </a>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>User Code</th>
			<th>Username</th>
			<th>Gender</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Account Number</th>
			<th>Balance</th>
			<th>Account Closed?</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="user" items="${listUsers}">
			<tr>
				<td>BANK000${user.idusers}-700-CA00</td>
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
	</table>
	<div>
		<a href="Welcome" class="btn btn-dark"> <<--Back </a>
	</div>
</body>
</html>