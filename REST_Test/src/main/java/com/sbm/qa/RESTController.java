package com.sbm.qa;

import javax.servlet.http.HttpServletRequest;

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

	@Autowired 
	private AuthenticationManager authManager;

	@RequestMapping(value = "/REST")	
	public ResponseEntity<String> getFile(@RequestParam String file, HttpServletRequest request){ 

		if(!authManager.isAuthenticated(request.getParameter("auth"), request.getHeader("Authorization"))){
			return new ResponseEntity<String>("Not authorized", HttpStatus.UNAUTHORIZED);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(fileManager.getContentType(file));
		return new ResponseEntity<String>(fileManager.readFile(file), headers, HttpStatus.OK);

	}	
}