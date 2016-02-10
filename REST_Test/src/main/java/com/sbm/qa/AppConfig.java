package com.sbm.qa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan("com.sbm.qa")
@PropertySources({
    @PropertySource(value="file:..//config.properties" , ignoreResourceNotFound=true),
    @PropertySource("classpath:config.properties")
})

public class AppConfig {

	@Value("${file.Path}")
	private String filePath;
	
	@Value("${test}")
	private String test;

	@Bean
	public String getFilePath() {
		System.out.println("File path is " + filePath);
		System.out.println("TEST PARAMETER : " + this.test);
		return filePath;
	}	
}
