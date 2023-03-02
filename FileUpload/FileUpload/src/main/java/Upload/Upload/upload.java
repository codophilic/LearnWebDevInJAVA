package Upload.Upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

public class upload extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory()); 
		
		List<FileItem> multifiles  = sf.parseRequest(null);
		for(FileItem i: multifiles) {
			i.write(new File("C:\\Users\\MEET\\Desktop\\LearnWebDevInJAVA\\FileUpload\\FileUpload\\ListofFiles" +i.getName()));
		}
		
		PrintWriter out = response.getWriter();
		out.println("Uploaded");
		}
		catch(Exception e) {
			
		}
		
	}

}
