<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
out.println("page belongs to :"+ab.getfName()+"<br>");
String msg = (String)request.getAttribute("msg");
out.println(msg);
%>
<a href="Book.html">AddBookDetails</a>
<a href="view1">ViewAllDetails</a>
<a href="logout">Logout</a>
</body>
</html>