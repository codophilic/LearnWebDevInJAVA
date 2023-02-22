package Cookies.CreateUserIDandPassword;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserIDandPassword extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String UserId = (String) req.getParameter("UserID");
		String password = (String) req.getParameter("pass");
		
		Cookie cookieUserId = new Cookie("UserID",(String)UserId); // Creating a object of cookie which accepts variable and string value
		Cookie cookiePass = new Cookie("pass",(String)password);
		res.addCookie(cookieUserId);
		res.addCookie(cookiePass);
		
		/*
		 Now this cookies get passed to the client with response
		 */
		
		PrintWriter out = res.getWriter();
		out.println("Acount registerd successfully");
		
	}
}
