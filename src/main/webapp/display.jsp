<%@ page contentType="text/html;charset=UTF-8" %>
<%
    if(session.getAttribute("keyLogin") == null){
        response.sendRedirect("login.jsp");
    }
%>
<html>
<head>
    <title>Display</title>
</head>
<body>

</body>
</html>
