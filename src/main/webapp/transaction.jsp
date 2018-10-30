<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    if(session.getAttribute("keyLogin") == null){
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>transactions</title>
</head>
<body>

    <br/>
    <h3>Perform Debit or Credit Operations </h3>
    <br/>
    
    <form action="actions/addTransaction.jsp" method="post">
       Account number : <input type="text" name="accountnumber" />
        <br/>
       Amount : <input type="text" name="amount"/>
        <br/>
        <input type="submit" value="credit" name="operation"/>
        <input type="submit" value="debit" name ="operation"/>
        
    </form>
</body>
</html>