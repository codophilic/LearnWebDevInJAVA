package Cookies.LoginUserIDandPassword;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUserIDandPassword extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
	
		PrintWriter out = res.getWriter();
//		res.setContentType("text/html;charset=UTF-8");
//		out.println("<html><body><form><form action='login' method='get'>"
//				+"<h2>Login Using your new useID and password</h2>"
//				+"Enter your UserID"
//				+"<input type = 'text' name='UserID'><br>"
//				+ "Enter your password"
//				+"<input type='text' name='pass'><br>"
//				+"<input type='submit'>"
//				+"</form></body></html>"); //Need to use sendReidrect method to call this web page 
		
		
	
			
		String LoginUserID = (String) req.getParameter("UserID");
		String LoginPassword = (String) req.getParameter("pass");
		
		/*
		 Now when the client request there are multiplies cookies associated with the request
		 */
		
		
		
		Cookie cookies[] = req.getCookies(); // Creating array of cookies
		if (cookies == null) {
            out.println(
                "<h1>You are new user, go to home page");
            return;
        }

		String SetUserid ="";
		String Setpass="";
		
		for(Cookie c:cookies) {
			if(c.getName().equals("UserID")) { // Don;t use cookies object of calling subject m use variable which was used for declaration
				SetUserid= c.getValue();
			}
			if(c.getName().equals("pass")) {
				Setpass = c.getValue();
			}
		}
		if(SetUserid.equals(LoginUserID)){
			if(Setpass.equals(LoginPassword)) {
				
				out.println("Login successfully");
				return;
			}
			else {
				
				out.println("Wrong Credentials");
				return;
			}
		}
		out.println("Wrong UserID");
		out.close();
		
}
}
