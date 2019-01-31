package com.qa.business.service;

import com.qa.persistence.domain.Account;

public interface AccountService {
	String getAllAccounts();
	String createAccount(String account);
	String deleteAccount(Long id);
	String updateAccount(Long id, String account);
	Account findaAccount(Long id);


}