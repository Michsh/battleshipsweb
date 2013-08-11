package battleshipsweb.components;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import battleshipsweb.exceptions.*;

public class FileManager {
	
	private String rootPath = null;

	public String getRootPath() {
		
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		
		this.rootPath = rootPath;
	}
	
	public void saveFile(MultipartFile file, String filename) throws FileIsNotAnImageException, FileExistsException {
		
		if(rootPath == null) {
			
			throw new RootPathNotSetException();
		}
		
		if(!isImage(file)) {
			
			throw new FileIsNotAnImageException();
		}
		
		File newFile = new File(rootPath + filename);
		
		if(newFile.exists()) {
			
			throw new FileExistsException();
		}
		
		try {
			
			newFile.createNewFile();
			
			FileUtils.writeByteArrayToFile(newFile, file.getBytes());
			
		}
		catch(IOException e) {
			
			System.out.println("IOException in Filemanager");
			System.out.println(e.getMessage());
		}
	}
	
	private boolean isImage(MultipartFile file) {
		
		return file.getContentType().startsWith("image");
	}
	
}
