package com.fg.mk.te.rk.vs.bankproject.service;

import java.util.List;

import com.fg.mk.te.rk.vs.bankproject.beans.AccountClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.TransactionClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.TransactionUtilitiesClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.UserAccountClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.UserClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.UtilityClass_A;

public interface AccountTransactionService {
	List<AccountClass_A> getListAccounts(String s);
	AccountClass_A getAccountById (int id);
	List<AccountClass_A> getListOtherAccountOfYours(int id);
	int RegisterTransaction(TransactionClass_A p);
	int UpdateAccount(TransactionClass_A t);
	int depositSameAccount(TransactionClass_A p, String idUtilityPresent);
	int updateDepositSameAccount(TransactionClass_A t);
	List<TransactionUtilitiesClass_A> getListAllUtilities();
	int AddUtilityDB(UtilityClass_A p);
	UtilityClass_A getUtilityByIdDB(int id);
	int updateUtilityDB(UtilityClass_A p);
	int deleteUtilityDB(int id);
	List<UtilityClass_A> getListAllUtilitiesExceptZero();
	int updatePayBillUtilityDB (TransactionClass_A t);
	int updatePayBillAccountUtilityDB (TransactionClass_A t);
	UserClass_A getUserByIdDB(String uname);
	int updateUserDB (UserClass_A u);
	List<UserAccountClass_A> getListAllUsers();
	UserAccountClass_A getUserByIdAdminDB(int idaccounts);
	int activateDeactivateAccountDB (int accountId, int activateDeActivate);
	List<UserClass_A> getListAllUsersForAdmin();
	int RegisterNewUserTable(UserAccountClass_A u);
	int RegisterNewAccountTable(UserAccountClass_A u, int userId);
	int fetchlastuserId();
	List<AccountClass_A> getListAllYourAccounts (String uname);
	List<TransactionClass_A> getListAllTransactions (int accountId);
}
