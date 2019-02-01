package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;


public class AccountServiceImpl implements AccountService {
	
	
	@Inject
	private AccountRepository repo;

	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String createAccount(String account) {
		return repo.createAccount(account);
	}

	@Override
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}

	@Override
	public String updateAccount(Long id, String account) {
		return repo.updateAccount(id, account);
	}

	@Override
	public Account findaAccount(Long id) {
		return repo.findaAccount(id);
	}

	}


