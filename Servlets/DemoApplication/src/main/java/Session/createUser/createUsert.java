package Session.createUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class createUsert extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession(); // HttpSession is an interface whos object is provided by Tomcat
		
		Date createTime = new Date(session.getCreationTime());
		String accountNo=(String)req.getParameter("account");
		
		session.setAttribute("accountNo", accountNo);
		session.setAttribute("NumberOfTimeAccessed",0);
		
		PrintWriter out = res.getWriter() ; // Object is provided by Tomcat
		
		out.println("Account "+accountNo+" is created");
		
		/*
		 If a new account number is enter the old session get removed.
		 */
		
		
		
	}
}
