package battleshipsweb.servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] pathSplit = req.getRequestURI().split("/");
		String[] splitIt = pathSplit[pathSplit.length - 1].split("\\.");
		String requestedImage = splitIt[0];
		
		File directory = new File(this.getServletContext().getInitParameter("userFilesRootPath"));
		File[] userFiles = directory.listFiles();
		
		for(File f : userFiles) {
			
			if(f.getName().startsWith(requestedImage)) {
				
				resp.setContentType("image/png");
				
				ServletOutputStream stream = resp.getOutputStream();
				stream.write(Files.readAllBytes(Paths.get(f.getAbsolutePath())));
				stream.close();
			}
		}
	}
}
