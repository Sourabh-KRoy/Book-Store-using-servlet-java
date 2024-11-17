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
UserBean ub = (UserBean)session.getAttribute("ubean");
out.println("page belongs to :"+ub.getfName()+"<br>");
String b= (String)(request.getAttribute("msg"));
float f = Float.parseFloat(b);
out.println("Total amout paid Successfully:"+f+"<br>");
%>
<a href="view3">ViewallBookDetails</a>
<a href="logout">Logout</a>
</body>
</html>