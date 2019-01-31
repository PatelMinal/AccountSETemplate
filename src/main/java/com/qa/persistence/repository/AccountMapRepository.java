package com.qa.persistence.repository;

import java.util.HashMap;

import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistance.util.JSONUtil;
import com.qa.persistence.domain.Account;

@Alternative
public class AccountMapRepository implements AccountRepository {

	private Map<Long, Account> account = new HashMap<>();

	private JSONUtil util = new JSONUtil();

	public String getAllAccounts() {

		return util.getJSONForObject(account);
	}

	
	
	public String createAccount(String jsonString) {

		Account accountnew = util.getObjectForJSON(jsonString, Account.class);
		Long id = (long) accountnew.getAccountNumber();
		accountnew.put(id, account);
		return "Created new account with first name: " + accountnew.getFirstName() + ", Last name: " + accountnew.getLastName()
				+ ", Account Number: " + accountnew.getAccountNumber();
	}

	public String deleteAccount(Long id) {

		account.remove(id);
		return "Removed account by the id: " + id;
	}

	public String updateAccount(Long id, String account) {
		//Account accountnew = util.getObjectForJSON(account, Account.class);
		return null;

	}
	

	public String findAccount(Long id) {
		return util.getJSONForObject(account.get(id));
	}

	public int getCountByFirstNames(String firstName) {
		int count = 0;
		for(Map.Entry<Long, Account> AccEntry: account.entrySet()) {  
			if(AccEntry.getValue().getFirstName().equals(firstName)) {
				count ++;
			}
		
		}
		return count;
	}

	
	public String findAccount1(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findaAccount(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



}

