package com.Rest.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	// path where we want save the file this is the static path if we have run this
	// code in different computer then we have to change the path

//	public final String UPLOAD_DIR = "C:\\Users\\prite\\Documents"
//			+ "\\workspace-spring-tool-suite-4-4.15.3.RELEASE\\bootRestBook\\src" + "\\main\\resources\\static\\img";
	
	//dynamic path we dnt need to change our path if we are going to used different computer.
	public final String UPLOAD_DIR = new ClassPathResource("static/img").getFile().getAbsolutePath();
	
	public FileUploadHelper()throws IOException{
		
	}
			
	// boolean function for file is upload or not
	public boolean uploadfile(MultipartFile file) {
		boolean f = false;
		try {
			// code for upload file
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}

}
