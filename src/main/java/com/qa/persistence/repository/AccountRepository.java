package com.qa.persistence.repository;

public interface AccountRepository {

	String getAllAccounts();
	String createAccount(String account);
	String deleteAccount(int accountnumber);
	String updateAccount(Long id, String account);

	
}
