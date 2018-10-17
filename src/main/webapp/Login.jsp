<%@page import="project.exception.ProjectException"%>
<%@ page import="project.service.UserService"%>
<%@ page import="project.dao.entity.UserEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
 	Validating User with Email ${param.id} ...
	<br/>
	<%
		 UserEntity user = new UserEntity();
	user.setLogin(request.getParameter("name"));
		
		user.setPassword(request.getParameter("password")) ;
		System.out.println("User Details: "+user);
		
		
		UserService service = new UserService();
		try
		{
			service.authenticate(user.getLogin(), user.getPassword());
			%>
			<h3>Valid user></h3>
			<% 
			session.setAttribute("keyId", user.getLogin());
			//pageContext.setAttribute("keyId", user.getLogin(), PageContext.SESSION_SCOPE);
		}
		catch(ProjectException e)
		{
			%>
			<h3>Invalid user id/password </h3>
			<%	
						
			response.sendRedirect("login.html");
				
				}
		%>
 </body>
</html> 