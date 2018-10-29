<%@ page import="project.exception.ProjectException"%>
<%@ page import="project.service.UserService"%>
<%@ page import="project.model.User"%>

<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page
	import="org.springframework.web.servlet.support.RequestContextUtils"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ApplicationContext ac = RequestContextUtils.findWebApplicationContext(request);

	UserService service = (UserService) ac.getBean("service");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Banking system</title>
</head>
<body>

	<br />
	<%
			try {
				service.createAccount(
						request.getParameter("name"), request.getParameter("dob"), 
						request.getParameter("address"), request.getParameter("email"), 
						request.getParameter("accounttype"));
				%><h3>Account successfully created</h3>
				<a href="Menu.html">click here for to perform other operation</a>
				<%
			} catch (ProjectException e) {
	%>
	<h3>Account not created</h3>
	<a href="Menu.html">click here for to perform other operation</a>
	<%
		response.sendRedirect("login.html");

		}
	%>
</body>
</html>
