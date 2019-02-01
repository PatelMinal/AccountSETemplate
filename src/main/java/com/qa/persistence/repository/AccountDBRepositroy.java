package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistance.util.JSONUtil;
import com.qa.persistence.domain.Account;



@Transactional(SUPPORTS)
@Default
public class AccountDBRepositroy implements AccountRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	

	
	@Override
	@Transactional(REQUIRED)
	public String getAllAccounts() {
		Query query = manager.createQuery("SELECT from Account a", Account.class);
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(query);
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account aAccount = util.getObjectForJSON(account, Account.class);
		manager.persist(aAccount);
		return "{\"Message\": \"Account Sucessfully Added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accountDB = findaAccount(id);
		if (accountDB != null) {
			manager.remove(accountDB);
		}
		return "{\"Message\": \"Account Sucessfully Removed\"}";
	}

	
	@Override
	public String updateAccount(Long id, String account) {
		Account update = util.getObjectForJSON(account, Account.class);
		manager.createQuery("UPDATE ACCOUNT SET firstName" + update.getFirstName());
		manager.createQuery("UPDATE ACCOUNT SET lastName" + update.getLastName());
		manager.createQuery("UPDATE ACCOUNT SET accountnumber" + update.getAccountNumber());
		
		return "Updated account with first name: " + update.getFirstName() + ", Last name: " + update.getLastName()
		+ ", Account Number: " + update.getAccountNumber();
	}

	@Override
	public Account findaAccount(Long id) {
		return manager.find(Account.class, id);
	}

	public String findAccount(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

