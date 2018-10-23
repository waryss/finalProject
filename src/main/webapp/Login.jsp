<%@page import="project.exception.ProjectException"%>
<%@ page import="project.service.UserService"%>
<%@ page import="project.dao.entity.UserEntity"%>

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
<title>Login</title>
</head>
<body>

	<br />
	<%
		UserEntity user = new UserEntity();
		user.setLogin(request.getParameter("name"));

		user.setPassword(request.getParameter("password"));
		System.out.println("User Details: " + user);

		try {
			service.authenticate(user.getLogin(), user.getPassword());
			session.setAttribute("keyId", user.getLogin());
			response.sendRedirect("Menu.jsp");
		} catch (ProjectException e) {
	%>
	<h3>Invalid user id/password</h3>
	<%
		response.sendRedirect("login.html");

		}
	%>
</body>
</html>
