package logout.Logout;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet implements Servlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("loginusernmae");
		/*
		 Removing an attribute from a session is exactly that, you have removed a single aspect of the session from the session.
		 The session itself is still valid.
		Session invalidate, invalidates that session so that it can no longer be used.
		 */
		session.invalidate();
		/*
		 Session invalidation means session destroying.So if session is destroyed,it indicates that 
		 server cant identify the client which has visited in previous.
		 So now it creates a new session id for that client.
		 */
		response.sendRedirect("index.html");
		
	}

}
