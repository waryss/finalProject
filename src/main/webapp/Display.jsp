<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.util.StringUtils" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="project.model.Transaction" %>
<%@ page import="project.service.UserService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    if (session.getAttribute("keyLogin") == null) {
        response.sendRedirect("login.jsp");
    }

    ApplicationContext ac = RequestContextUtils.findWebApplicationContext(request);

    UserService service = (UserService) (ac != null ? ac.getBean("service") : null);

    String accountId = request.getParameter("accountId") == null ? "" : request.getParameter("accountId");
%>
<html>
<head>
    <title>Display</title>
</head>
<body>

<c:out value="accountId"/>
<form action="./Display.jsp" method="post">
    Account Number :<input type="text" name="accountId" size="5" value="<%= accountId %>"/> <br> <br>

    From :<input type="text" name="datefrom"/>

    To :<input type="text" name="dateto"/>

    <input type="submit" value="display"/>
</form>

<%
    if (!StringUtils.isEmpty(accountId)&&(!StringUtils.isEmpty(request.getParameter("datefrom")))
            && (!StringUtils.isEmpty(request.getParameter("dateto")))) {
%>
<div>
    <h3>Transactions list for account number : <%= accountId %></h3>
    <ul>
        <%
            List<Transaction> list = service.displayStatement(Long.valueOf(accountId), request.getParameter("datefrom"), request.getParameter("dateto"));

            for (Transaction transaction : list) {

                String item = "<li>" +
                        " ID : " + transaction.getTransid() +
                        " | DESC : " + transaction.getDescription() +
                        " | CHEQUE NO: " + (transaction.getChequeNumber() ==null ? "": transaction.getChequeNumber())+
                        " | WITHDRAW : "+(transaction.getWithdraw() ==null ? "": transaction.getWithdraw())+
                        " | DEPOSIT : "+(transaction.getDeposit() ==null ? "": transaction.getDeposit())+
                        " | BALANCE : " + transaction.getAvailableBalance() +
                         "</li>";
        %>
        <%= item %>

    </ul>
</div>
<%
        }
        %>
<br>
<br>
<a href="Menu.jsp">click here for to perform other operation</a><%
    }
else if (!StringUtils.isEmpty(accountId) &&(StringUtils.isEmpty(request.getParameter("datefrom"))
    || (StringUtils.isEmpty(request.getParameter("dateto")))))%> <h3> Please enter valid details</h3><%
%>
</body>
</html>
