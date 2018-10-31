<%@ page contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%
	if(session.getAttribute("keyLogin") == null){
		response.sendRedirect("Login.jsp");
	}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Banking system</title>
</head>
<body>
	<br />
	<h3>Banking system</h3>
	
	<br />
	<a href="Createaccount.jsp">Create account</a>
	<br />
	<a href="Transaction.jsp">Transactions</a>
	<br />
	<a href="Display.jsp">Display Statement</a>
	<br />
	<a href="Card.jsp">Authorize Card Transaction</a>
</body>
</html>