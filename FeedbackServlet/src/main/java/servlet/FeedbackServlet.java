package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedbackServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		res.setContentType("text/html");
		String uname = (String)req.getParameter("name");
		String bname = (String)req.getParameter("bkname");
		String msg = (String)req.getParameter("message");
		
		System.out.println("username= "+uname);	
		System.out.println("Bookname= "+bname);	
		System.out.println("Feedback= "+msg);	
		
		
		
	}

}
