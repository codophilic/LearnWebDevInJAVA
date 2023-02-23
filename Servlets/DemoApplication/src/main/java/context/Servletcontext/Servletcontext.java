package context.Servletcontext;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servletcontext extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter() ;
		ServletContext ctx = req.getServletContext(); // Interface who object is created by tomcat
		String ip = ctx.getInitParameter("GeneralDB");
		
		out.println("General DB ip "+ip);
	}
}
