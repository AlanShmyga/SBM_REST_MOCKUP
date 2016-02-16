package com.sbm.qa;

import javax.xml.bind.DatatypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationManager {

	private boolean authRequired;
	private String basic_UserName;
	private String basic_password;

	public boolean isAuthenticated(String authType, String authHeader){
		
		if(authType==null){
			if(authRequired==false){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			
			if(authType.equals("HTTPBasic") && authHeader != null){
				return authenticateBasic(authHeader);
			}
			else if (authType.equals("SecurityToken")){
				return authenticateSecurityToken();
			}
			else if (authType.equals("OAuth2")){
				return authenticateOAuth2();
			}
		}
		
		return false;	
	}

	private boolean authenticateBasic(String authHeader){
		if(processAuthHeader(authHeader).equals(calculateBasicToken())){
			return true;
		}
		return false;
	}
	
	private boolean authenticateSecurityToken(){		
		throw new NotImplementedException();
	}
	
	private boolean authenticateOAuth2(){		
		throw new NotImplementedException();
	}
	
	private String processAuthHeader(String authHeader){
		String[] headerParts = authHeader.split(" ");
		return headerParts[headerParts.length-1];
	}
	
	private String calculateBasicToken() {
		String basicToken = DatatypeConverter.printBase64Binary((basic_UserName + ":" + basic_password).getBytes());
		return basicToken;
		
	}

	public String getUserName() {
		return basic_UserName;
	}

	public void setUserName(String userName) {
		this.basic_UserName = userName;
	}

	public String getPassword() {
		return basic_password;
	}

	public void setPassword(String password) {
		this.basic_password = password;
	}

	public boolean isAuthRequired() {
		return authRequired;
	}

	public void setAuthRequired(boolean authRequired) {
		this.authRequired = authRequired;
	}

}
