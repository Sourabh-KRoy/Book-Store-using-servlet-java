<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 UserBean ub =(UserBean)session.getAttribute("ubean");
 out.println("Welcome Customer:"+ub.getfName()+"<br>");
%>
<a href="Register.html">NewCustomer?</a>
<a href="view2">ViewAllBookDetails</a>
<a href="logout">Logout</a>
</body>
</html>