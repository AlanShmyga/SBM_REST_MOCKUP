package com.sbm.qa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.sbm.qa")
@PropertySource("file:c://config.properties")
    //@PropertySource("classpath:config.properties")

public class AppConfig {

	@Value("${file.Path}")
	private String filePath;
	
	@Value("${test}")
	private String test;

	@Bean
	public FileManager fileManager() {
		FileManager fm = new FileManager();
		fm.setFilePath(filePath);
		return fm;
	}	
}
