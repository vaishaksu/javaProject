package com.fg.mk.te.rk.vs.bankproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.fg.mk.te.rk.vs.bankproject.beans.AccountClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.TransactionClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.UserClass_A;

public class AccountTransactionDaoImpl implements AccountTransactionDao  {
	HttpSession session;
	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {  
		this.template = template;  
	}


	public List<AccountClass_A> getListAccounts(String s){
		System.out.printf("SSSS: "+ s);
		String sql = "select idaccounts, balance from accounts a join users u where a.idusers = u.idusers AND u.username = '" + s + "'"; // JOIN Query
		return template.query(sql, new RowMapper<AccountClass_A>(){ 

			public AccountClass_A mapRow(ResultSet rs, int row) throws SQLException {  
				AccountClass_A e = new AccountClass_A();  
				e.setIdaccounts(rs.getInt(1));
				e.setBalance(rs.getDouble(2));
				return e;
			}
		});  
	}
	
	public AccountClass_A getAccountById (int id) {
		String sql = "select * from accounts where idaccounts = ?";
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<AccountClass_A>(AccountClass_A.class));  
	}
	
	public List<AccountClass_A> getListOtherAccountOfYours(int id) {
		String sql = "select * from accounts where idaccounts != " + id + " AND idusers = (select idusers from accounts where idaccounts = "+ id +")"; // Using SUB-QUERY
;
		return template.query(sql, new RowMapper<AccountClass_A>(){ 

			public AccountClass_A mapRow(ResultSet rs, int row) throws SQLException {  
				AccountClass_A e = new AccountClass_A();  
				e.setIdaccounts(rs.getInt(1));
				e.setBalance(rs.getDouble(2));
				return e;
			}
		});  
	}
	
	public int RegisterTransaction(TransactionClass_A p) {  
		System.out.println("++++++++++++++++++> ");
		System.out.println("---------------- " + p.getTransactionDate());
		String sql="insert into transactions(senderAccountId, transactionDate, idutilities, receiverAccountId, transactionsAmount) values("+p.getSenderAccountId()+",'"+p.getTransactionDate()+"',"+ null +", "+ p.getReceiverAccountId() +", "+p.getTransactionsAmount()+")"; 
		return template.update(sql);  
	}
	
//	public int UpdateAccount(TransactionClass_A t, AccountClass_A p) {  
//		System.out.println("++++++++++++++++++> ");
////		System.out.println("---------------- " + p.getTransactionDate());
////		String sql="insert into accounts(senderAccountId, transactionDate, idutilities, receiverAccountId, transactionsAmount) values("+p.getSenderAccountId()+",'"+p.getTransactionDate()+"',"+ null +", "+ p.getReceiverAccountId() +", "+p.getTransactionsAmount()+")"; 
////		String sql = "update accounts where idaccounts = "+ t.getSenderAccountId() +" set ";
//		return template.update(sql);  
//	}
}
