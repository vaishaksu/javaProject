package com.fg.mk.te.rk.vs.bankproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fg.mk.te.rk.vs.bankproject.beans.AccountClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.TransactionClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.UserAccountClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.UserClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.UtilityClass_A;
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

	public int UpdateAccount(TransactionClass_A t) {
		// TODO Auto-generated method stub
		return accountTransactionDao.UpdateAccount(t);
	}

	public int updateDepositSameAccount(TransactionClass_A t) {
		// TODO Auto-generated method stub
		return accountTransactionDao.updateDepositSameAccount(t);
	}

	public List<UtilityClass_A> getListAllUtilities() {
		// TODO Auto-generated method stub
		return accountTransactionDao.getListAllUtilities();
	}

	public int AddUtilityDB(UtilityClass_A p) {
		// TODO Auto-generated method stub
		return accountTransactionDao.AddUtilityDB(p);
	}

	public UtilityClass_A getUtilityByIdDB(int id) {
		// TODO Auto-generated method stub
		return accountTransactionDao.getUtilityByIdDB(id);
	}

	public int updateUtilityDB(UtilityClass_A p) {
		// TODO Auto-generated method stub
		return accountTransactionDao.updateUtilityDB(p);
	}

	public int deleteUtilityDB(int id) {
		// TODO Auto-generated method stub
		return accountTransactionDao.deleteUtilityDB(id);
	}

	public List<UtilityClass_A> getListAllUtilitiesExceptZero() {
		// TODO Auto-generated method stub
		return accountTransactionDao.getListAllUtilitiesExceptZero();
	}

	public int depositSameAccount(TransactionClass_A p, String idUtilityPresent) {
		// TODO Auto-generated method stub
		return accountTransactionDao.depositSameAccount(p, idUtilityPresent);
	}

	public int updatePayBillUtilityDB(TransactionClass_A t) {
		// TODO Auto-generated method stub
		return accountTransactionDao.updatePayBillUtilityDB(t);
	}
	
	public int updatePayBillAccountUtilityDB (TransactionClass_A t) {
		return accountTransactionDao.updatePayBillAccountUtilityDB(t);
	}

	public UserClass_A getUserByIdDB(String uname) {
		// TODO Auto-generated method stub
		return accountTransactionDao.getUserByIdDB(uname);
	}

	public int updateUserDB(UserClass_A u) {
		// TODO Auto-generated method stub
		return accountTransactionDao.updateUserDB(u);
	}

	public List<UserAccountClass_A> getListAllUsers() {
		// TODO Auto-generated method stub
		return accountTransactionDao.getListAllUsers();
	}

	public UserAccountClass_A getUserByIdAdminDB(int idaccounts) {
		// TODO Auto-generated method stub
		return accountTransactionDao.getUserByIdAdminDB(idaccounts);
	}

	public int activateDeactivateAccountDB(int accountId, int activateDeActivate) {
		// TODO Auto-generated method stub
		return accountTransactionDao.activateDeactivateAccountDB(accountId, activateDeActivate);
	}

	public List<UserClass_A> getListAllUsersForAdmin() {
		// TODO Auto-generated method stub
		return accountTransactionDao.getListAllUsersForAdmin();
	}

	public int RegisterNewUserTable(UserAccountClass_A u) {
		// TODO Auto-generated method stub
		return accountTransactionDao.RegisterNewUserTable(u);
	}

	public int RegisterNewAccountTable(UserAccountClass_A u, int userId) {
		// TODO Auto-generated method stub
		return accountTransactionDao.RegisterNewAccountTable(u, userId);
	}

	public int fetchlastuserId() {
		// TODO Auto-generated method stub
		return accountTransactionDao.fetchlastuserId();
	}

	public List<AccountClass_A> getListAllYourAccounts(String uname) {
		// TODO Auto-generated method stub
		return accountTransactionDao.getListAllYourAccounts(uname);
	}
}
