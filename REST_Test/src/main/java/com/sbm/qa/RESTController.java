package com.sbm.qa;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

	@Autowired
	private FileManager fileManager;
	
	@RequestMapping(value = "/REST")	
	public ResponseEntity<String> getFile(@RequestParam String file, HttpServletResponse response){ 
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(fileManager.getContentType(file));
			return new ResponseEntity<String>(fileManager.readFile(file), headers, HttpStatus.OK);
		
	}	
}