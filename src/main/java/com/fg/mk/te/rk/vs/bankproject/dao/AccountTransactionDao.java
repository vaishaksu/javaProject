package com.fg.mk.te.rk.vs.bankproject.dao;

import java.util.List;

import com.fg.mk.te.rk.vs.bankproject.beans.AccountClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.TransactionClass_A;

public interface AccountTransactionDao {
	List<AccountClass_A> getListAccounts(String s);
	AccountClass_A getAccountById (int id);
	List<AccountClass_A> getListOtherAccountOfYours(int id);
	int RegisterTransaction(TransactionClass_A p);
}
