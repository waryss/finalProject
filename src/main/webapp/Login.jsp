<%@ page import="module9.db.JDBCHelper"%>
<%@ page import="finalProject.model.User"%>
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
		User user = new User();
	user.setName(request.getParameter("name"));
		
		user.setPassword(request.getParameter("password")) ;
		System.out.println("User Details: "+user);
		
		// Saving the Object into Table
		JDBCHelper helper = new JDBCHelper();
		helper.createConnection();
		boolean flag  = helper.loginUser(user);
		helper.closeConnection();
		
		if(flag){
			%>
				<h3>Valid user></h3>
				
			<%	
				
				
				session.setAttribute("keyId", user.getName());
								
				pageContext.setAttribute("keyId", user.getName(), PageContext.SESSION_SCOPE);
						
				}else{
			%>
				<h3>Invalid user id/password </h3>
			<%	
			response.sendRedirect("login.html");
				
				}
			%>
 </body>
</html> 