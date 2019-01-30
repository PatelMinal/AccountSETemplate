package com.qa.util;

import java.util.Map;

import com.google.gson.Gson;
import com.qa.persistence.domain.Account;

public class JSONUtil {
	private Gson gson;

	public JSONUtil() {
		this.gson = new Gson();
	}
	
	
	public String getJSONForObject(Object obj) {
		
//		Jsonb jsonb = JsonbBuilder.create();
//		String result = jsonb.toJson(dog);
		
		return gson.toJson(obj);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> clazz) {
		return gson.fromJson(jsonString, clazz);
	}

	public String getObjectForJSON(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account getObjectForJSON(Map<Long, Account> account, Class<Account> class1) {
		// TODO Auto-generated method stub
		return null;
	}

}


