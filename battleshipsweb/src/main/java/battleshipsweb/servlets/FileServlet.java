package battleshipsweb.servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import battleshipsweb.exceptions.FileNotFoundException;

public class FileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private String rootPath = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		rootPath = config.getInitParameter("userFilesRootPath");
		
		if(rootPath == null) {
			
			throw new ServletException("Init param :userFilesRootPath: is not set.");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		
		String username = extractUsername(req.getRequestURI());
		
		File avatar = null;
		
		try {
			
			avatar = findAvatar(username);
			
		}
		catch(FileNotFoundException e) {
			
			throw new ServletException(e);
		}
		
		try {
			
			sendImage(avatar, resp.getOutputStream());
		}
		catch(IOException e) {
			
			throw new ServletException(e);
		}
	}
	
	private String extractUsername(String requestURI) {
		
		String[] pathSplit = requestURI.split("/");
		String[] splitIt = pathSplit[pathSplit.length - 1].split("\\.");
		
		return splitIt[0];
	}
	
	private File findAvatar(String username) throws FileNotFoundException {
		
		File directory = new File(rootPath);
		File[] userFiles = directory.listFiles();
		
		for(File f : userFiles) {
			
			if(f.getName().startsWith(username)) {
				
				return f;
			}
		}
		
		throw new FileNotFoundException(String.format("Image for user %s not found.", username));
	}
	
	private void sendImage(File image, ServletOutputStream stream) throws IOException {
		
		stream.write(Files.readAllBytes(Paths.get(image.getAbsolutePath())));
		stream.close();
	}
}
