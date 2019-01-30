package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountMapRepository implements AccountRepository {

	Map<Long, Account> account = new HashMap<>();
	
	private JSONUtil util = new JSONUtil();
	
	
	public String getAllAccounts() {
	
		return util.getJSONForObject(account);
	}
	
	

	public String createAccount(String Newaccount) {
		Account account1 = util.getObjectForJSON(Newaccount, Account.class);
		Long id = (long)account1.getAccountNumber();
		account.put(id, account1);
		//account.put((long) account.size(), account1);
		//account.get(id);
		return "Created new account: " + account1.getFirstName() + account1.getLastName() + account1.getAccountNumber();
	}

	public String deleteAccount(int accountnumber) {
		account.remove(accountnumber);
		return "Removed account by account number" +accountnumber;
	}

	
	public String updateAccount(Long id, String account) {
		//Account account1 = util.getObjectForJSON(account, Account.class);
	///	account.get(id, account);
		
		return null;
	}
	

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	
	//public String findAccount(int accountnumber) {
	//	return util.getJSONForObject(account.get(accountnumber));
	//}

	public int getCountForFirstNames(String firstName) {
		int count = 0;
		for(Map.Entry<Long, Account> AccEntry; account.entrySet()) {
			if(AccEntry.getValue().getFirstName().equals(firstName)) {
				count ++;
			}
		}
		return count; 
		
	}
	
}





