<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Current Account</title>
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
<title>Pay Utility</title>
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
	<div class="container mt-5 col-md-5">
		<h2 class="mb-5">
			<center>Pay for Utility</center>
		</h2>

		<div class="mb-3">
			<form:form action="PostPayBill" method="post"
				modelAttribute="payBill">

				<div class="form-group">
					<label> Select Account to Transfer Money:</label> <select
						name="senderAccountId">
						<c:forEach var="account" items="${listAllYourAccounts}">
							<option value="${account.idaccounts}">CA000${account.idaccounts}000IN
								- $${account.balance}</option>
						</c:forEach>
					</select>

				</div>

				<form:hidden path="receiverAccountId" value="107" />
				<div class="form-group">
					<label> Select Utility to Pay: </label> <select name="idutilities">
						<c:forEach var="bill" items="${listUtilitiesToPay}">
							<option value="${bill.idutilities}">UTI000${bill.idutilities}600${bill.utilityName}00
								- $${bill.utilityPrice}</option>
						</c:forEach>
					</select>

				</div>
				<div class="form-group">
					<label>Transfer Amount:</label>
					<form:input class="form-control" type="number"
						path="transactionsAmount" />
				</div>

				<input type="submit" class="btn btn-primary" value="Transfer" />
			</form:form>
		</div>
	</div>

</body>
</html>