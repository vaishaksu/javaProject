<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIEW ALL ACCOUNTS</title>
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
<title>Pay bill</title>
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
	<div class="container mt-5">
		<h5>
			<center>
				Welcome <b><%=session.getAttribute("fullname")%></b>!
			</center>
		</h5>

		<div class="mt-5 text-center">
			<%
			String uname1 = (String) session.getAttribute("username");
			if (!uname1.equals("admin")) {
				out.print(
				"<a href='Accounts' class='btn btn-secondary'> VIEW ALL ACCOUNTS OF YOURS </a> <a href='ViewProfile' class='btn btn-secondary'> VIEW YOUR PROFILE </a> <a href='AddUtility' class='btn btn-secondary'> ADD UTILITY </a> <a href='ListAllUtilities' class='btn btn-secondary'>LIST ALL UTILITIES </a>");
			}
			%>

			<%
			String uname = (String) session.getAttribute("username");
			if (uname.equals("admin")) {
				out.print("<a href='ListAllUsers' class='btn btn-secondary'>View all Customer's Account</a>");
			}
			%>

			<div class="mt-5">
				<h3 class="mb-3 text-success">GROUP MEMBERS - Date: 04-12-2021</h3>
				<div>
					<h6>1. Vaishak Surendran (c0785212)</h6>
					<h6>2. Tom Edison C0785563</h6>
					<h6>3. Francis George (C0789818)</h6>
					<h6>4. Manpreet Kaur (c0771598)</h6>
					<h6>5. Rupinderbir kaur (C0792091)</h6>
				</div>
			</div>
		</div>

	</div>
</body>
</html>