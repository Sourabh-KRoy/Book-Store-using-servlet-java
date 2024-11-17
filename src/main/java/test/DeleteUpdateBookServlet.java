package test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial") 
@WebServlet("/delete1")
public class DeleteUpdateBookServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired..<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}else {
			String bCode = req.getParameter("bcode");
			ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("alist");
			BookBean bb = null;
			Iterator<BookBean> it = al.iterator();
			while(it.hasNext()) {
				bb = it.next();
				if(bCode.equals(bb.getCode())) {
					break;
				}
			}//end of loop
		int k= new DeleteBookDetailsDAO().delete(bb);
		if(k>0) {
			req.setAttribute("msg", "Book details updated Successfully..<br>");
			req.getRequestDispatcher("DeleteUpdateBookDetails.jsp").forward(req, res);
		}else {
			req.setAttribute("msg", "Book details not deleted..<br>");
		}
	}
	}
}

