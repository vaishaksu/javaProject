<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Utility</title>
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
	<form:form method="post" action="EditUitilitySave" modelAttribute="utility">
		<form:hidden path="idutilities"/>
		<div class="form-group">
			<label for="exampleInputEmail1">Utility Name</label>
			<form:input type="text" class="form-control" path="utilityName"
				aria-describedby="emailHelp" />
		</div>
		<br />


		<div class="form-group">
			<label for="exampleInputEmail1">Utility Price</label>
			<form:input type="number" class="form-control" path="utilityPrice"
				aria-describedby="utilityPriceHelp" />
		</div>
		<br />

		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
</body>
</html>