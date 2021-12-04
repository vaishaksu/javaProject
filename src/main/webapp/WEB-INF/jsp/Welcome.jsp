<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		<p>
			WELCOME <b><%=session.getAttribute("fullname")%></b>!
		</p>
		<a href="Logout" class="btn">Logout</a>

		<%
			String uname1 = (String)session.getAttribute("username");
			if(!uname1.equals("admin")) {
				out.print( "<a href='Accounts' class='btn btn-secondary'> VIEW ALL ACCOUNTS OF YOURS </a> <a href='ViewProfile' class='btn btn-secondary'> VIEW YOUR PROFILE </a> <a href='AddUtility' class='btn btn-secondary'> ADD UTILITY </a> <a href=ListAllUtilities' class='btn btn-secondary'>LIST ALL UTILITIES </a>");
			}
		%>

		<%
			String uname = (String)session.getAttribute("username");
			if(uname.equals("admin")) {
				out.print("<a href='ListAllUsers' class='btn btn-secondary'>View all Customer's Account</a>");					
			}
		%>
	</div>
</body>
</html>