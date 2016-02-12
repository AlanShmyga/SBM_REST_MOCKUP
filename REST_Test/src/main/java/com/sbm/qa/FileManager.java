package com.sbm.qa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class FileManager {

	private String filePath;

	public void setFilePath(String filePath){
		this.filePath = filePath;
	}

	public String readFile(String file){

		file = this.filePath + file;
		
			FileReader fileReader;
			StringBuilder result = new StringBuilder();
			try {
				fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String buf = bufferedReader.readLine();
				while(buf != null){
					result.append(buf);
					result.append("\n");
					buf = bufferedReader.readLine(); 
				}
				bufferedReader.close();
			} catch (IOException e) {
				System.out.println("file read error");
				e.printStackTrace();
			}
			return result.toString();
	}

	public boolean isFileExists(String file) {

		File fileToCheck = new File(file);
		if(fileToCheck.exists() && fileToCheck.isFile()){
			return true;
		}
		else{	
			return false;
		}
	}

	public MediaType getContentType(String file){ 
		if(file.endsWith(".xml")){
			return MediaType.APPLICATION_XML;

		}
		else if(file.endsWith(".json")){
			return MediaType.APPLICATION_JSON;
		}
		else{
			return MediaType.TEXT_HTML;
		}
	}

}
