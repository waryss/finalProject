<%@ page import="project.model.Transaction" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="project.service.UserService" %>
<%@ page import="org.springframework.util.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    if (session.getAttribute("keyLogin") == null) {
        response.sendRedirect("login.jsp");
    }

    ApplicationContext ac = RequestContextUtils.findWebApplicationContext(request);

    UserService service = (UserService) (ac != null ? ac.getBean("service") : null);

    String accountId = request.getParameter("accountId");
%>
<html>
<head>
    <title>Display</title>
</head>
<body>

<form action="./Display.jsp" method="post">
    Account Number :<input type="text" name="accountId" value="${accountId}"/> <br>

    From :<input type="text" name="datefrom"/>

    To :<input type="text" name="dateto"/>
    <br/>
    <input type="submit" value="display"/>
</form>

<%
    if (!StringUtils.isEmpty(accountId)) {
        List<Transaction> list = service.displayStatement(Long.valueOf(accountId), request.getParameter("datefrom"), request.getParameter("dateto"));
        for (Transaction transaction : list) {
            System.out.println(transaction);
        }
    }
%>
</body>
</html>
