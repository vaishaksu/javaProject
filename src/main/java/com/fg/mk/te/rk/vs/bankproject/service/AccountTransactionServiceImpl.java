package com.fg.mk.te.rk.vs.bankproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fg.mk.te.rk.vs.bankproject.beans.AccountClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.TransactionClass_A;
import com.fg.mk.te.rk.vs.bankproject.dao.AccountTransactionDao;

public class AccountTransactionServiceImpl implements AccountTransactionService {
	@Autowired
	public AccountTransactionDao accountTransactionDao;
	
	public List<AccountClass_A> getListAccounts(String s) {
		return accountTransactionDao.getListAccounts(s);
	}

	public AccountClass_A getAccountById(int id) {
		return accountTransactionDao.getAccountById(id);
	}

	public List<AccountClass_A> getListOtherAccountOfYours(int id) {
		return accountTransactionDao.getListOtherAccountOfYours(id);
	}

	public int RegisterTransaction(TransactionClass_A p) {
		return accountTransactionDao.RegisterTransaction(p);
	}
}
