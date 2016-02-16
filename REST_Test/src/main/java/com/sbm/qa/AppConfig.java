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
	@PropertySource("classpath:default.properties"),
	@PropertySource(value = "file:C://SBM_QA_REST//config.properties", ignoreResourceNotFound = true)
})

public class AppConfig {

	@Value("${file.Path}")
	private String filePath;
	
	@Value("${test}")
	private String test;
	
	@Value("${auth.required}")
	private boolean auth_Required;
	
	@Value("${auth.base.username}")
	private String basic_UserName;
	
	@Value("${auth.base.password}")
	private String basic_password;

	@Bean
	public FileManager fileManager() {
		FileManager fm = new FileManager();
		fm.setFilePath(filePath);
		return fm;
	}	
	
	@Bean
	public AuthenticationManager authManager(){
		AuthenticationManager authManager = new AuthenticationManager();
		authManager.setAuthRequired(auth_Required);
		authManager.setUserName(basic_UserName);
		authManager.setPassword(basic_password);
		return authManager;
	}
}
