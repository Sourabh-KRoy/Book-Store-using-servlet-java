<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="viewbook.css">
</head>
<body>
<table>
      <tr>
         <th> Code </th>
         <th> Name </th>
         <th> Author </th>
         <th> Price </th>
         <th> Qty </th>
         <th> Buy </th>
       </tr>
<%
UserBean ub = (UserBean)session.getAttribute("ubean");

        
ArrayList<BookBean> al = (ArrayList<BookBean>)session.getAttribute("ulist");

out.println("Page belongs to :" +ub.getfName()+"<br>");
if(al.size()==0){
	out.println("<tr><td colspan='6' >Books Not Available...</td></tr>");
}else{
	Iterator<BookBean> it = al.iterator();
	while(it.hasNext()){
		BookBean bb = it.next();
		out.println("<tr>");
		out.println("<td>" +bb.getCode()+ "</td>");
		out.println("<td>" +bb.getName()+ "</td>");
		out.println("<td>" + bb.getAuthor()+ "</td>");
		out.println("<td>" +bb.getPrice()+ "</td>");
		out.println("<td>" +bb.getQty()+ "</td>");
		out.println("<td> <a href='Buy?bcode="+bb.getCode()+"'>Buy</a> </td>");
		out.println("</tr>");		
	}
}
%>
</table></br>
<button><a href="logout">Logout</a></button>
</body>
</html>