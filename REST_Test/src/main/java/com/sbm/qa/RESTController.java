package com.sbm.qa;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {
	
	@ResponseBody
	@RequestMapping(value = "/REST")
	public  ResponseEntity<String> getFile(@RequestParam String file, HttpServletResponse response){
		System.out.println("Requested file is : " + file);
		
		try{
			FileManager fileManager = new FileManager(file);
			response.setContentType(fileManager.getContentType());
			return new ResponseEntity<String>(fileManager.readFile(), HttpStatus.OK);
		}
		catch(IOException e){
			System.out.println(e);
		}
		return new ResponseEntity<String>("File Not Found", HttpStatus.NOT_FOUND);
		
	}

	
}
