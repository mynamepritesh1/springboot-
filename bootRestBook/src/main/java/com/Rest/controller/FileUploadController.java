package com.Rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Rest.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());

		// upload file code first we write code in uploadfilehelper and then those code
		// we have usaed here

		try {

			boolean f = fileUploadHelper.uploadfile(file);
			if (f) {
				// return ResponseEntity.ok("file successfully uploaded");
				// code for dynamic upload file folder classPath
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/img/")
						.path(file.getOriginalFilename()).toUriString());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");

	}

}
