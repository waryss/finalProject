<%@ page import="project.exception.ProjectException"%>
<%@ page import="project.service.UserService"%>
<%@ page import="project.model.User"%>

<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page import="java.security.InvalidParameterException" %>

<%@ page contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<% 
ApplicationContext ac = RequestContextUtils.findWebApplicationContext(request);
UserService service = (UserService) (ac != null ? ac.getBean("service") : null);
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
		try {
			User user = service.authenticate(request.getParameter("name"), request.getParameter("password"));
			session.setAttribute("keyLogin", user.getLogin());
			session.setAttribute("keyId", user.getId());
			response.sendRedirect("../Menu.jsp");
		} catch (InvalidParameterException |ProjectException e) {
	%>
	<h3>Invalid user id/password</h3>
	<%
		response.sendRedirect("../Login.jsp");

		}
	%>
</body>
</html>
