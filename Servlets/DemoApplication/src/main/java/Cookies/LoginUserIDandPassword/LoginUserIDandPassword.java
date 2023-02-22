package Cookies.LoginUserIDandPassword;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUserIDandPassword extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String UserId = (String) req.getParameter("UserID");
		String password = (String) req.getParameter("pass");
		
		/*
		 Now when the client request there are multiplies cookies associated with the request
		 */
		
		
		
		Cookie cookies[] = req.getCookies(); // Creating array of cookies
		String Userid ="";
		String pass="";
		for(Cookie c:cookies) {
			if(c.getName().equals("cookieUserId")) {
				Userid= c.getValue();
			}
			if(c.getName().equals("cookiePass")) {
				pass = c.getValue();
			}
		}
		System.out.println(UserId+UserId.getClass()+Userid+Userid.getClass());
		if(UserId.equals(Userid)){
			if(password.equals(pass)) {
				PrintWriter out = res.getWriter();
				out.println("Login successfully");
			}
			else {
				PrintWriter out = res.getWriter();
				out.println("Wrong Credentials");
			}
		}
		PrintWriter out = res.getWriter();
		out.println("Wrong UserID");
		
}
}
