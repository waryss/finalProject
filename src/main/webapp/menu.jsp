<%@ page contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%
	if(session.getAttribute("keyLogin") == null){
		response.sendRedirect("login.jsp");
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
	<a href="createaccount.jsp">Create account</a>
	<br />
	<a href="transaction.jsp">Transactions</a>
	<br />
	<a href="display.jsp">Display Statement</a>
	<br />
	<a href="card.jsp">Authorize Card Transaction</a>
</body>
</html>