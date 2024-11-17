package test;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/AdminLog")
public class AdminLoginServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
	AdminBean ab = new AdminLoginDAO().login(req.getParameter("uname"),req.getParameter("pword"));
	if(ab==null) {
		req.setAttribute("msg","invalid login process..<br>");
		req.getRequestDispatcher("Home.jsp").forward(req, res);
	}else {
		HttpSession hs = req.getSession();//Creating new Session
		hs.setAttribute("abean",ab);
		req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
	}
}
}
