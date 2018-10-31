<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="project.service.UserService" %>
<%@page import="project.exception.ProjectException"%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    ApplicationContext ac = RequestContextUtils.findWebApplicationContext(request);

    UserService service = (UserService) (ac != null ? ac.getBean("service") : null);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
		try {
			service.displayStatement(request.getParameter("dateFrom"), request.getParameter("dateTo"));
			
		} catch (ProjectException e) {
			e.printStackTrace();
		}
	%>
</body>
</html>