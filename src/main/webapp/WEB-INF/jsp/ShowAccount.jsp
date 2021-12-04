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
	<div>
		<b>Account Number:</b> CA000${account.idaccounts}000IN <b>Account
			Balance:</b> ${account.balance}
	</div>
	<div>
		<a href="TransferDifferentAccount/${account.idaccounts}"
			class="btn btn-info">Transfer Money to different account of yours
			(withdraw)</a> 
		<a href="DepositToSameAccount/${account.idaccounts}"
			class="btn btn-info">Deposit money in the same account of yours</a>
	</div>

</body>
</html>