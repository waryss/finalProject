<%@ page contentType="text/html;charset=UTF-8" %>
<%
    if(session.getAttribute("keyLogin") == null){
        response.sendRedirect("Login.jsp");
    }
%>
<html>
<head>
    <title>Card</title>
</head>
<body>
    <form action="actions/ManageCard.jsp" method="post">
        card number :<input type="text" name="cardnumber" />
        <br/>
        amount :<input type="text" name="amount"/>
        <br/>
        <input type="submit" value="authorize"/>
    </form>
</body>
</html>
