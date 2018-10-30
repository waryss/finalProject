<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page import="project.model.Account"%>

<%@ page import="project.service.UserService"%>

<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
	ApplicationContext ac = RequestContextUtils.findWebApplicationContext(request);

	UserService service = (UserService) (ac != null ? ac.getBean("service") : null);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Banking System</title>
</head>
<body>
<%

				int accountid=Integer.parseInt(request.getParameter("accountnumber"));
				int amount=Integer.parseInt(request.getParameter("amount"));
				Account account=service.getAccount(accountid);
				Date date= new Date();
				if(request.getParameter("operation").equals("credit")){
				    service.deposit(account,amount);
				    service.createTransaction(date, "deposit", 0, amount, account.getBalance(), accountid);

				%><h3>Account successfully credited</h3>
				<a href="../menu.jsp">click here for to perform other operation</a>
				<%}else if(request.getParameter("operation").equals("debit")){
				    service.withdraw(account,amount);
				    service.createTransaction(date, "withdraw", amount, 0, account.getBalance(), accountid);
						%><h3>Account successfully debited</h3>
						<a href="../menu.jsp">click here for to perform other operation</a>
					<%} %>
</body>
</html>