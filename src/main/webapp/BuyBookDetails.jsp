<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
UserBean ub =(UserBean)session.getAttribute("ubean");
BookBean bb =(BookBean)request.getAttribute("bbean");
out.println("Page belongs to :"+ub.getfName()+"<br>");
out.println("BookCode:"+bb.getCode()+"<br>");
out.println("BookName:"+bb.getName()+"<br>");
out.println("BookAuthor:"+bb.getAuthor()+"<br>");
out.println("BookPrice:"+bb.getPrice()+"<br>");
out.println("BookQty:"+bb.getQty()+"<br>");
%>
<form action="buybook" method="post">
<input type="hidden" name="bcode" value=<%=bb.getCode()%>>
ReqBooks:<input type="text" name="rqty"><br>
<input type="submit" name="Buybook">
</form>
 
</body>
</html>