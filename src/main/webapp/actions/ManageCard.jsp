<%@ page import="project.service.UserService" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="project.model.Account" %>
<%@ page import="project.model.CreditCard" %>
<%@ page import="org.springframework.util.StringUtils" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: Glenn MANFOUMBI
  LocalDate: 31/10/2018
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ApplicationContext ac = RequestContextUtils.findWebApplicationContext(request);

    UserService service = (UserService) (ac != null ? ac.getBean("service") : null);
%>
<html>
<head>
    <title>Card Authorization</title>
</head>
<body>
    <% if (!StringUtils.isEmpty(request.getParameter("cardnumber")) &&
            !StringUtils.isEmpty(request.getParameter("amount"))){
        int cardNumber=Integer.parseInt(request.getParameter("cardnumber"));
        int amount=Integer.parseInt(request.getParameter("amount"));
        CreditCard card= service.getCard(cardNumber);
        LocalDate date= LocalDate.now();
        if(card!=null) {
            Account account=service.getAccount(card.getAccountId());
            service.withdraw(account, amount);
            service.createTransaction(date, "deposit", 0, amount, account.getBalance(), account.getAccountNumber());
    %><h3>Account successfully debited</h3>
    <a href="../Menu.jsp">click here for to perform other operation</a>
    <%}
    }
    else {
    %><h3>Account not found</h3>
    <a href="../Menu.jsp">click here for to perform other operation</a>
<% } %>
</body>
</html>
