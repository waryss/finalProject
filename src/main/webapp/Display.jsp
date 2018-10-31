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
 <form action="actions/DisplayTransaction.jsp" method="post">
        From :<input type="text" name="datefrom" />
   
        To :<input type="text" name="dateto"/>
        <br/>
        <input type="submit" value="display"/>
    </form>
</body>
</html>
