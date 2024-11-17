package test;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/reg2")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		 UserBean ub = new UserBean();
		 ub.setuName(req.getParameter("nm"));
		 ub.setpWord(req.getParameter("pword"));
		 ub.setfName(req.getParameter("fname"));
		 ub.setlName(req.getParameter("lname"));
		 ub.setAddress(req.getParameter("address"));
		 ub.setmId(req.getParameter("mid"));
		 ub.setPhno(Long.parseLong(req.getParameter("ph")));
		 int k = new RegisterDAO().register(ub);
		 if(k>=0) {
			 req.setAttribute("msg", "User Registered SuccessFully..<br>");
			 RequestDispatcher rd =req.getRequestDispatcher("Register.jsp");
			 rd.forward(req, res);
		 }
	}

}
