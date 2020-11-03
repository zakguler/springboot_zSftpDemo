package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sftp.upload.UpAndDownloadSafe;

@RestController
@RequestMapping()
public class HelloController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/hello")
	public String sayHiToDeath() {
		return "Hi from zSFTP demo...";
	}
	
	@PostMapping("/readfile")
	public String getFile(
			  @RequestBody String reqBody
			, @RequestHeader("Accept-Encoding") String encoding
			, HttpServletRequest request
			, HttpServletResponse response)
			 {
		return reqBody;		
	}

	@GetMapping("/upload")
	public String doUploadMyFile() {
		UpAndDownloadSafe upload = new UpAndDownloadSafe();
		upload.uploadSafe();
		return "Upload file completed...";
	}


	@GetMapping("/download")
	public String doDownloadMyFile() {
		UpAndDownloadSafe upload = new UpAndDownloadSafe();
		upload.downloadSafe();
		return upload.downloadSafe();
	}

}
