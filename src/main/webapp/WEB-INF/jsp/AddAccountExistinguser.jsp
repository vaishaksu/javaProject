<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Account Existsing User</title>
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
<title>Pay bill</title>
</head>
<body>
	<div class="container">
		<h2>Add amount to the existing user</h2>

		<form:form method="post" action="PostAddExistingUserAccount"
			modelAttribute="addExistingUserAccountAdmin">
			<div class="form-group">
				<label for="exampleInputEmail1">Select Users from the
					existing list</label> <select name="idusers">
					<c:forEach var="user" items="${listAllUserAccountAdmin}">
						<option value="${user.idusers}">${user.fname}&nbsp;${user.lastname}
							- ${user.username}</option>
					</c:forEach>
				</select>
			</div>
			<br />

			<div class="form-group">
				<label for="exampleInputEmail1">Amount</label>
				<form:input type="number" class="form-control" path="balance"
					aria-describedby="balanceHelp" />
			</div>
			<br />

			<button type="submit" class="btn btn-primary">Add</button>
		</form:form>

	</div>

</body>
</html>