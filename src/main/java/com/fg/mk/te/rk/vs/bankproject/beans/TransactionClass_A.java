package com.fg.mk.te.rk.vs.bankproject.beans;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TransactionClass_A {
	public int idtransactions;
	public int senderAccountId;
	Date dt = new Date();

	SimpleDateFormat sdf = 
	     new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public String transactionDate = sdf.format(dt);
	
	public int idutilities;
	public int receiverAccountId;
	public double transactionsAmount;

	public int getIdtransactions() {
		return idtransactions;
	}

	public void setIdtransactions(int idtransactions) {
		this.idtransactions = idtransactions;
	}

	public int getSenderAccountId() {
		return senderAccountId;
	}

	public void setSenderAccountId(int senderAccountId) {
		this.senderAccountId = senderAccountId;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getIdutilities() {
		return idutilities;
	}

	public void setIdutilities(int idutilities) {
		this.idutilities = idutilities;
	}

	public int getReceiverAccountId() {
		return receiverAccountId;
	}

	public void setReceiverAccountId(int receiverAccountId) {
		this.receiverAccountId = receiverAccountId;
	}

	public double getTransactionsAmount() {
		return transactionsAmount;
	}

	public void setTransactionsAmount(double transactionsAmount) {
		this.transactionsAmount = transactionsAmount;
	}
}
