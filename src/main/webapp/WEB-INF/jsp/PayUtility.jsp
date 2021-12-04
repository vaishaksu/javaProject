<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIEW ALL ACCOUNTS</title>
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
		<form:form action="PostPayBill" method="post"
			modelAttribute="payBill">

			<label> Select Account to Transfer Money:</label>
			<select name="senderAccountId">
				<c:forEach var="account" items="${listAllYourAccounts}">
					<option value="${account.idaccounts}">CA000${account.idaccounts}000IN
						- $${account.balance}</option>
				</c:forEach>
			</select>
			<form:hidden path="receiverAccountId" value="107"/>
			<label> Select Utility to Pay: </label>
			<select name="idutilities">
				<c:forEach var="bill" items="${listUtilitiesToPay}">
					<option value="${bill.idutilities}">UTI000${bill.idutilities}600${bill.utilityName}00 - $${bill.utilityPrice}</option>
				</c:forEach>
			</select>
			<label>Transfer Amount:</label>
			<form:input type="number" path="transactionsAmount" />

			<input type="submit" class="btn btn-primary" value="Transfer" />
		</form:form>
	</div>

</body>
</html>