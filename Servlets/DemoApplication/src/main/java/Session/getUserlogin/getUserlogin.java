package Session.getUserlogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class getUserlogin extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		
		// session.removeAttribute("accountNo); Remove the session
		
		String accountNo =(String)session.getAttribute("accountNo");
		String Gotaccountno = ( String )req.getParameter("account");

		if (Gotaccountno.equals(accountNo)) {
			int NumberofTimeAccessed = (int)session.getAttribute("NumberOfTimeAccessed");
			
			PrintWriter out = res.getWriter() ; // Object is provided by Tomcat
			
			out.println("Account number "+accountNo+" is accessed "+NumberofTimeAccessed+" times which was created on "+session.getLastAccessedTime());
			
			session.setAttribute("NumberOfTimeAccessed",NumberofTimeAccessed+1);
		}
		else {
			PrintWriter out = res.getWriter() ; // Object is provided by Tomcat
			
			out.println("There is no such accounts");
			
		}
		
	}
}
