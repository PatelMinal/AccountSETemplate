package com.qa.service;

public interface AccountService {

	String getAllAccounts();

	String addAccount(String account);

	String deleteAccount(int accountnumber);

}