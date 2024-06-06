package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedbackServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException,IOException {

		
		String uname = (String)req.getParameter("name");
		String bname = (String)req.getParameter("bkname");
		String msg = (String)req.getParameter("message");
		
//		System.out.println("username= "+uname);	
//		System.out.println("Bookname= "+bname);	
//		System.out.println("Feedback= "+msg);
		
		String url="jdbc:mysql://localhost:3306/feedback";
		String user="root";
		String password="krbs01";
		
		Connection conn= null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection(url, user, password);
			
			
			String sql="INSERT INTO feedbackdetails(NAME,BOOK_NAME,FEEDBACK) VALUES(?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, bname);
			pstmt.setString(3, msg);
			
			
			
			res.setContentType("text/html");
			int rs=pstmt.executeUpdate();
			if(rs==1) {
				res.sendRedirect("unsuccess.html");
			}else {
				res.sendRedirect("unsuccess.html");
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new ServletException("DataBase Error: "+e.getMessage());	
			
		}
		
	}

}
