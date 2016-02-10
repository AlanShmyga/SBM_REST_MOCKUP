package com.sbm.qa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
	
	String file = "";
	AppConfig configuration = new AppConfig();
	String filePath = configuration.getFilePath();
	String testFile = filePath + file;
	
	FileManager(String file) throws IOException{
		this.file = file;
	}
		
	public String readFile() throws FileNotFoundException, IOException{

		FileReader fileReader = new FileReader(testFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String buf = bufferedReader.readLine();
		StringBuilder result = new StringBuilder();

		while(buf != null){
			result.append(buf);
			result.append("\n");
			buf = bufferedReader.readLine(); 
		}
		bufferedReader.close();
		
		return result.toString();
	}
	
	public boolean isFileExists() {
		
		File fileToCheck = new File(testFile);
		if(fileToCheck.exists() && fileToCheck.isFile()){
			System.out.println("File " + testFile + " exists and this is a file");
			return true;
		}
		else{	
			System.out.println("File " + testFile + " does not exists or this is not a file");
			return false;
		}
	}

	public String getContentType(){ 
		if(file.endsWith(".xml")){
			System.out.println("This is a xml");
			return "text/xml";

		}
		else if(file.endsWith(".json")){
			System.out.println("Thi is a json");
			return "application/json";
		}
		else{
			System.out.println("Error reading extension");
			return "text/html";
		}
	}
	
}
