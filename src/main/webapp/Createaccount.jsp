<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    if(session.getAttribute("keyLogin") == null){
        response.sendRedirect("Login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Banking system</title>
</head>
<body>
    <br/>
    <h3>Banking system </h3>
    <br/>
    
    <form action="actions/AddAccount.jsp" method="post">
        Name : <input type="text" name="name" />
        <br/>
         DOB:<input type="text" name="dob" />
        <br/>
         Address :
           <br/>
         <textarea rows="4" cols="50" name="address"></textarea>
        <br/>
         Email :<input type="text" name="email" />
        <br/>
        Type of account<SELECT name="accounttype" size="1">
		<OPTION>Current
		<OPTION>SB
		</SELECT>
        <br/>
        <input type="submit" value="create account"/>
    </form>

</body>
</html>