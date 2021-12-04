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
<body>
	<form:form action="PostTransaction" method="post" modelAttribute="newTransaction">
		TRANFER FROM: 
		 <b>CA000${yourAccounts.idaccounts}000IN</b> - <b>$${yourAccounts.balance}</b>
		<form:hidden path="senderAccountId" value="${yourAccounts.idaccounts}" />
		<label> TRANSFER TO:</label> <select name="receiverAccountId">
				<c:forEach var="account" items="${listYourOtherAccounts}">
					<option value="${account.idaccounts}">CA000${account.idaccounts}000IN
						- $${account.balance}</option>
				</c:forEach>
		</select>
		Transfer Amount: <form:input type="number" path="transactionsAmount"/>
		
		<input type="submit" class="btn btn-primary" value="Transfer"/>
	</form:form>
</body>
</html>