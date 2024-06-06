package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Firstwebservlet extends HttpServlet{
public void doPost(HttpServletRequest req,HttpServletResponse res) {
	
	
	res.setContentType("text/html");
	String uname = (String)req.getParameter("usrnme");
	String password = (String)req.getParameter("psswrd");
	
	System.out.println("username= "+uname);	
	System.out.println("password= "+password);	
	
	}

}
