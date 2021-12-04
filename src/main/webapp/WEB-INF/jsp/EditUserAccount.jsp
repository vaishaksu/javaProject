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
<title>Edit User</title>
</head>
<body>
	<form:form method="post" action="EditUserAccountSave"
		modelAttribute="userAccount">
		<form:hidden path="idusers" />

		<div>
			<label> Account Number </label>
			<form:hidden path="idaccounts" />
			<b><label> CA000${userAccount.idaccounts}000IN </label></b>
		</div>

		<div>
			<label> Balance </label>
			<form:hidden path="balance" />
			<b><label> $${userAccount.balance} </label></b>
		</div>

		<div class="form-group">
			<label for="exampleInputEmail1">First Name</label>
			<form:input type="text" class="form-control" path="fname"
				aria-describedby="balanceHelp" />
		</div>
		<br />

		<div class="form-group">
			<label for="exampleInputEmail1">Last Name</label>
			<form:input type="text" class="form-control" path="lastname"
				aria-describedby="emailHelp" />
		</div>
		<br />

		<form:hidden path="password"/>

		<div class="form-group">
			<label for="exampleInputEmail1">Username</label>
			<form:input type="text" class="form-control" path="username"
				aria-describedby="emailHelp" />
		</div>
		<br />

		<div class="form-group">
			<label for="exampleInputEmail1">Email</label>
			<form:input type="email" class="form-control" path="email"
				aria-describedby="emailHelp" />
		</div>
		<br />

		<div class="form-group">
			<label for="exampleFormControlSelect1">Gender</label>

			<form:select class="form-select" path="gender" items="${genderItems}"></form:select>
		</div>
		<br />


		<button type="submit" class="btn btn-primary">Save</button>
	</form:form>
</body>
</html>