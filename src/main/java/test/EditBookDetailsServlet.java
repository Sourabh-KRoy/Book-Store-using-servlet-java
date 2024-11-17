package test;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditBookDetailsServlet extends HttpServlet {
@SuppressWarnings("unchecked")
@Override
protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	HttpSession hs = req.getSession(false);
	if(hs==null) {
		req.setAttribute("msg","Session Expired..<br>");
		req.getRequestDispatcher("Home.jsp").forward(req, res);
	}else {
		String bCode = req.getParameter("bCode");
		ArrayList<BookBean> al =(ArrayList<BookBean>)hs.getAttribute("alist");
		BookBean bb = null;
		Iterator<BookBean> it = al.iterator();
		while(it.hasNext()) {
			bb = it.next();
			if(bCode.equals(bb.getCode())) {
				break;
			}
		}
		req.setAttribute("bbean",bb);
		req.getRequestDispatcher("EditBookDetails.jsp").forward(req, res);
	}
}
}
