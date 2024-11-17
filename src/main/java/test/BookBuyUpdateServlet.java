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
@WebServlet("/buybook")
public class BookBuyUpdateServlet extends HttpServlet
{
	BookBean bb=null;
	String b;
	int rqty;
	float amount;
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	 ServletException,IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg","Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}else {
			String bCode = req.getParameter("bcode");
			b=req.getParameter("rqty");
			rqty=Integer.parseInt(b);
			ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("ulist");
			BookBean bb = null;
			Iterator<BookBean> it = al.iterator();
			while(it.hasNext()) {
				bb = it.next();
				if(bCode.equals(bb.getCode())) {
					break;
				}
			}//end of loop
			amount = bb.getPrice();
			amount=amount*rqty;
			b=""+amount;
			int k = new BookBuyUpdateDAO().buy(bb,rqty);
			if(k>0){
			req.setAttribute("msg", b);
			req.getRequestDispatcher("BookBuyUpdate.jsp").forward(req, res);
		}
		
	}

}
}

