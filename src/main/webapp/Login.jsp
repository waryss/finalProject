<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    if(session.getAttribute("keyLogin") != null){
        response.sendRedirect("Menu.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Banking System</title>
</head>
<body>

    <br/>
    <h3>Enter your Id and Password below </h3>
    <br/>
    
    <form action="actions/CheckLogin.jsp" method="post">
        <input type="text" name="name" />
        <br/>
        <input type="password" name="password"/>
        <br/>
        <input type="submit" value="login"/>
    </form>

</body>
</html>