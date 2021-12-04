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
<title>Insert title here</title>
</head>
<body>
	WELCOME
	<b><%=session.getAttribute("fullname")%></b>!
	<a href="Logout" class="btn">Logout</a>

	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Account Number</th>
			<th>Balance</th>
		</tr>
		<c:forEach var="account" items="${listAccount}">
			<tr>
				<td><c:if test="${account.accountclosed == 1}">
						<a href="ShowAccount/${account.idaccounts}"
							class="btn btn-primary">CA000${account.idaccounts}000IN</a></td>
				</c:if>
				<c:if test="${account.accountclosed == 0}">
					CA000${account.idaccounts}000IN				
				</c:if>
				<td>$${account.balance}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>