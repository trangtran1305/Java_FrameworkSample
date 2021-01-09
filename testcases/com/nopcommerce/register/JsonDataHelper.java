package com.nopcommerce.register;



import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonDataHelper {
	public static JsonDataHelper getData(String Jsonfile) {
		try {
			ObjectMapper mapper=new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(new File(Jsonfile),JsonDataHelper.class );
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@JsonProperty("firstname")
	String firstname;
	@JsonProperty("lastname")
	String lastname;
	@JsonProperty("company")
	String company;
	@JsonProperty("email")
	String email;
	@JsonProperty("password")
	String password;
	
	public String getFirstName() {
		return firstname;
	}
	public String getLastName() {
		return lastname;
	}
	public String getCompanyName() {
		return company;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
}
