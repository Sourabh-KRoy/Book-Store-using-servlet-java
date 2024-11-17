package test;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/CustomerLog")
public class CustomerLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse rs)throws ServletException,IOException {
		UserBean ub = new CustomerLoginDAO().login(req.getParameter("uname"),
				req.getParameter("pword"));
		if(ub==null) {
			req.setAttribute("msg", "Invailid Login process...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, rs);
		}else {
			HttpSession hs=req.getSession();//crating new Session
			hs.setAttribute("ubean", ub);
		}
			req.getRequestDispatcher("CustomerLogin.jsp").forward(req, rs);
		}
	}


