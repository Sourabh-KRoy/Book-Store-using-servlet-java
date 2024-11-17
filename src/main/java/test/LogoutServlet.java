package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
  HttpSession hs = req.getSession(false);
  if(hs==null) {
	  req.setAttribute("msg","Session expired..<br>");
	  req.getRequestDispatcher("Home.jsp").forward(req, res);
  }else {
	  req.getRequestDispatcher("Logout.jsp").forward(req,res);
  }
}
}