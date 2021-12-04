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
<title>List All Utilities</title>
</head>
<body>
	WELCOME
	<b><%=session.getAttribute("fullname")%></b>!
	<div>
		<a href="PayUtility" class="btn btn-info">Wanna pay a bill?</a>
	</div>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Utility Code</th>
			<th>Utility Name</th>
			<th>Utility Price</th>
			<th>Government Utility Code</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="utility" items="${listUtilities}">
			<tr>
				<td>UTI000${utility.idutilities}600${utility.utilityName}00</td>
				<td>${utility.utilityName}</td>
				<td>$${utility.utilityPrice}</td>
				<td>GOVT-${utility.utilityName}-UTI000${utility.idutilities}-MENT0007</td>
				<td><a href="EditUtility/${utility.idutilities}"
					class="btn btn-info">Edit</a> <a
					href="DeleteUtility/${utility.idutilities}" class="btn btn-danger">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<div>
		<a href="Welcome" class="btn btn-dark"> <<--Back </a>
	</div>
</body>
</html>