<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
<title>Login</title>
</head>
<body>
	<header>
		<nav
			class="navbar navbar-expand-sm navbar-toggleable-sm navbar-dark bg-dark border-bottom box-shadow mb-3">
			<div class="container-fluid">
				<a class="navbar-brand">Banking</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target=".navbar-collapse"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div
					class="navbar-collapse collapse d-sm-inline-flex justify-content-between">
					<ul class="navbar-nav flex-grow-1">
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a class="nav-link text-light" href="Register"> Sign
								Up</a></li> &nbsp; &nbsp; &nbsp; &nbsp;
						<li><a class="nav-link text-light" href="Login">Login</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<div class="container col-md-4">
		<h2>Login</h2>

		<form:form method="post" action="loginVerification">
			<div class="form-group">
				<label for="exampleInputEmail1">Username</label>
				<form:input type="text" class="form-control" path="username"
					aria-describedby="emailHelp" />
			</div>
			<br />
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label>
				<form:input type="password" class="form-control"
					id="exampleInputPassword1" path="password" />
			</div>
			<br />

			<%
				String error = (String)session.getAttribute("error");
				if (error != null) {
					out.print("<i class='text-danger'>Invalid Username or password</i> <br/>");
				}
			%>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>

	</div>
</body>
</html>