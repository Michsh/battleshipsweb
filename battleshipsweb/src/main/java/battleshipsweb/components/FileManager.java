package battleshipsweb.components;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import battleshipsweb.exceptions.*;

public class FileManager {
	
	private String rootPath = null;
	
	public boolean isImage(MultipartFile file) {
		
		return file.getContentType().startsWith("image");
	}
	
	private File[] getDirectoryContent() {
		
		File directory = new File(rootPath);
		
		return directory.listFiles();
	}
	
	private boolean fileExists(String filename) {
		
		File[] files = getDirectoryContent();
		
		for(File f : files) {
			
			if(f.getName().equals(filename)) {
				
				return true;
			}
		}
		
		return false;
	}
	
	private String getMultipartFileExtension(MultipartFile file) {
		
		String[] tmp = file.getOriginalFilename().split("\\.");
		
		return "." + tmp[tmp.length - 1];
	}
	
	public void saveMultipartFile(MultipartFile file, String filename) throws CannotSaveMultipartException {
		
		String extension = getMultipartFileExtension(file);
		
		if(fileExists(filename + extension)) {
			
			throw new CannotSaveMultipartException("File " + filename + extension + " exists");
		}
		
		File newFile = new File(rootPath + filename + extension);
		
		try {
			
			newFile.createNewFile();
			FileUtils.writeByteArrayToFile(newFile, file.getBytes());
			
		}
		catch(IOException e) {
			
			throw new CannotSaveMultipartException(e);
		}
	}
	
	public String getRootPath() {
		
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		
		this.rootPath = rootPath;
	}
	
	//TODO scheduled jobs
}
