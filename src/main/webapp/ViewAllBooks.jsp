<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="View.css">
<link rel="stylesheet" href="NewFile.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<header>
	<div class="header">
	<a href="#" class="logo"><i class="fa-solid fa-book"></i>BookStore</a>
	<div class="search">
		<input class="input" type="text" placeholder="Search Here.."><div><i class="fa-solid fa-magnifying-glass"></i></div>
		
	</div>
	</div>
	<div class="header-2">
	<nav class="navbar">
		<a>Home</a>
		<a>Category</a>
		<a>Product</a>
		<a>Deal</a>
		<a>Contact</a>
	</nav>
	<div class="icons">
		<a class="fa-solid fa-cart-shopping"></a>
		<a class="fa-solid fa-heart"></a>
		<a href="CustomerLogin.html" class="fa-solid fa-circle-user"></a>
	</div>
	</div>
</header>
<% 
AdminBean ab = (AdminBean)session.getAttribute("abean");

ArrayList<BookBean> al =(ArrayList<BookBean>)session.getAttribute("alist");
out.println("Page Belongs to: "+ab.getfName()+"<br>");
if(al.size()==0){
	
	out.println("Books Not Available.....<br>");
}
else{
	Iterator<BookBean> it = al.iterator();
	while(it.hasNext()){
		BookBean bb = it.next();
		
out.println(bb.getCode()+"&nbsp&nbsp"+bb.getName()+"&nbsp&nbsp"+bb.getAuthor()+"&nbsp&nbsp"+bb.getPrice()+"&nbsp&nbsp"+bb.getQty()+"&nbsp&nbsp"+"<a href='edit?bcode="+bb.getCode()+"'>Edit</a>"+"&nbsp&nbsp"+"<a href='delete?bcode="+bb.getCode()+"'>Delete</a>"+"<br>"
);
	}
}
%>

<a href="logout">LogOut</a>
</body>
</html>