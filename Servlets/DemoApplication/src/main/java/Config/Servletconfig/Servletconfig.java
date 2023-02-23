package Config.Servletconfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servletconfig extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		ServletConfig con = getServletConfig();
		
		String ip = con.getInitParameter("ParticularDB");
		out.println("Particular DB ip "+ip);
		
	}
}
