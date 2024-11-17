<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Pannel</title>
<link rel="stylesheet" href="Admin.css">
</head>
<body>
<form class="admin">
<% 
AdminBean ab = (AdminBean)session.getAttribute("abean");
out.println("welcome Admin : "+ab.getfName()+"<br>");
%>
</form>

<a href="Book.html">AddBookDetails</a>
<a href="view1">ViewAllBookDetails</a>
<a href="logout">Logout</a>
</body>
</html>