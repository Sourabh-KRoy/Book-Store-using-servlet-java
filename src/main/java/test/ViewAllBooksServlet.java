package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view1")
public class ViewAllBooksServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
	HttpSession hs = req.getSession(false);
	if(hs==null) {
		req.setAttribute("msg","Session Expire...<br>");
		req.getRequestDispatcher("Home.jsp").forward(req,res);
	}else {
		ArrayList<BookBean> al = new ViewAllBooksDAO().retrieve();
		hs.setAttribute("alist", al);
		req.getRequestDispatcher("ViewAllBooks.jsp").forward(req, res);
		
		
	}
	
	}
}

