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
import com.fg.mk.te.rk.vs.bankproject.beans.TransactionUtilitiesClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.UserAccountClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.UserClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.UtilityClass_A;

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
		String sql = "select * from accounts a join users u where a.idusers = u.idusers AND u.username = '" + s + "'"; // JOIN Query
		return template.query(sql, new RowMapper<AccountClass_A>(){ 

			public AccountClass_A mapRow(ResultSet rs, int row) throws SQLException {  
				AccountClass_A e = new AccountClass_A();  
				e.setIdaccounts(rs.getInt(1));
				e.setBalance(rs.getDouble(2));
				e.setAccountclosed(rs.getInt(4));
				return e;
			}
		});
	}

	public AccountClass_A getAccountById (int id) {
		String sql = "select * from accounts where idaccounts = ?";
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<AccountClass_A>(AccountClass_A.class));  
	}

	public List<AccountClass_A> getListOtherAccountOfYours(int id) {
		String sql = "select * from accounts where idaccounts != " + id + " AND accountclosed = 1 AND idusers = (select idusers from accounts where idaccounts = "+ id +")"; // Using SUB-QUERY

		return template.query(sql, new RowMapper<AccountClass_A>(){ 

			public AccountClass_A mapRow(ResultSet rs, int row) throws SQLException {  
				AccountClass_A e = new AccountClass_A();  
				e.setIdaccounts(rs.getInt(1));
				e.setBalance(rs.getDouble(2));
				e.setAccountclosed(rs.getInt(3));
				return e;
			}
		});  
	}

	// Inserting a new row as the transaction happens
	public int RegisterTransaction(TransactionClass_A p) {  
		System.out.println("++++++++++++++++++> ");
		System.out.println("---------------- " + p.getTransactionDate());
		String sql="insert into transactions(senderAccountId, transactionDate, idutilities, receiverAccountId, transactionsAmount) values("+p.getSenderAccountId()+",'"+p.getTransactionDate()+"',"+ null +", "+ p.getReceiverAccountId() +", "+p.getTransactionsAmount()+")"; 
		return template.update(sql);  
	}

	// Same account to different account of yours 
	public int UpdateAccount(TransactionClass_A t) {  
		System.out.println("++++++++++++++++++> ");

		// Updating multiple rows
		String sql = "update accounts set balance = case when idaccounts =" + t.getSenderAccountId() + " then balance - " + t.getTransactionsAmount() + " when idaccounts = " + t.getReceiverAccountId()+ " then balance + " + t.getTransactionsAmount() + " else balance end;";
		return template.update(sql);  
	}

	public int depositSameAccount(TransactionClass_A p, String idUtilityPresent) {
		String sql= null;
		if (idUtilityPresent != null) {
			sql = "insert into transactions(senderAccountId, transactionDate, idutilities, receiverAccountId, transactionsAmount) values("+p.getSenderAccountId()+",'"+p.getTransactionDate()+"',"+ p.getIdutilities() +", "+ p.getReceiverAccountId() +", "+p.getTransactionsAmount()+")";
		} else {
			sql = "insert into transactions(senderAccountId, transactionDate, idutilities, receiverAccountId, transactionsAmount) values("+p.getSenderAccountId()+",'"+p.getTransactionDate()+"',"+ null +", "+ p.getReceiverAccountId() +", "+p.getTransactionsAmount()+")";
		}	 			

		return template.update(sql);  
	}

	public int updateDepositSameAccount(TransactionClass_A t) {
		String sql = "update accounts  set balance = case when idaccounts = " + t.getSenderAccountId()+ " and idaccounts = " + t.getReceiverAccountId() + " then balance + " + t.getTransactionsAmount() + " else balance end;";
		return template.update(sql);  
	}

	public List<TransactionUtilitiesClass_A> getListAllUtilities() {
//		String sql = "select * from utilities"; // JOIN Query
		String sql = "select * from utilities u left join transactions t on u.idutilities = t.idutilities group by u.idutilities;";
		return template.query(sql, new RowMapper<TransactionUtilitiesClass_A>(){ 

			public TransactionUtilitiesClass_A mapRow(ResultSet rs, int row) throws SQLException {  
				TransactionUtilitiesClass_A e = new TransactionUtilitiesClass_A();  
				e.setIdutilities(rs.getInt(1));
				e.setUtilityName(rs.getString(2));
				e.setUtilityPrice(rs.getDouble(3));
				e.setIdtransactions(rs.getInt(4));
				return e;
			}
		}); 
	}

	// Inserting a new row as the utility happens
	public int AddUtilityDB(UtilityClass_A p) {  
		String sql="insert into utilities(utilityName, utilityPrice) values('"+p.getUtilityName()+"', "+p.getUtilityPrice()+")"; 
		return template.update(sql);  
	}

	public UtilityClass_A getUtilityByIdDB(int id){  
		String sql="select * from utilities where idutilities=?";
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<UtilityClass_A>(UtilityClass_A.class));
	}

	public int updateUtilityDB(UtilityClass_A p){ 
		System.out.println("1: ==== " + p.getUtilityName());
		System.out.println("2: ==== " + p.getUtilityPrice());
		System.out.println("3: ==== " + p.getIdutilities());
		String sql="update utilities set utilityName='"+p.getUtilityName()+"', utilityPrice= " +p.getUtilityPrice()+ " where idutilities=" +p.getIdutilities()+ "";  
		return template.update(sql);  
	}

	public int deleteUtilityDB(int id){  
		String sql="delete from utilities where idutilities="+id+"";  
		return template.update(sql);  
	}

	public List<UtilityClass_A> getListAllUtilitiesExceptZero() {
		String sql = "select * from utilities where utilityPrice > 0"; // JOIN Query
		return template.query(sql, new RowMapper<UtilityClass_A>(){ 

			public UtilityClass_A mapRow(ResultSet rs, int row) throws SQLException {  
				UtilityClass_A e = new UtilityClass_A();  
				e.setIdutilities(rs.getInt(1));
				e.setUtilityName(rs.getString(2));
				e.setUtilityPrice(rs.getDouble(3));
				return e;
			}
		}); 
	}

	public int updatePayBillUtilityDB (TransactionClass_A t) {
		String sql = "UPDATE utilities set utilityPrice = utilityPrice - " + t.getTransactionsAmount()+ " where idutilities = " + t.getIdutilities() + ";";
		return template.update(sql);
	}

	public int updatePayBillAccountUtilityDB (TransactionClass_A t) {
		String sql = "UPDATE accounts SET balance = case when idaccounts = " + t.getSenderAccountId() + " then balance - " + t.getTransactionsAmount() + " when idaccounts = " + t.getReceiverAccountId() + " then balance + " + t.getTransactionsAmount() + " else balance end";
		return template.update(sql);
	}


	public UserClass_A getUserByIdDB(String uname) {  
		String sql="select * from users where username=?";
		return template.queryForObject(sql, new Object[]{uname},new BeanPropertyRowMapper<UserClass_A>(UserClass_A.class));
	}

	// Update user
	public int updateUserDB (UserClass_A u) {
		String sql = "UPDATE users set username = '" + u.getUsername() + "', password = '" + u.getPassword()+"', gender = '" + u.getGender() + "', fname = '" + u.getFname() + "', lastname = '" + u.getLastname() + "', email = '"+u.getEmail()+"'  where idusers = " + u.getIdusers() + ";";
		return template.update(sql);
	}

	// Fetch All Users
	public List<UserAccountClass_A> getListAllUsers() {  
		String sql="select * from users u join accounts a where a.idusers = u.idusers AND u.idusers != 0;";
		return template.query(sql, new RowMapper<UserAccountClass_A>(){ 

			public UserAccountClass_A mapRow(ResultSet rs, int row) throws SQLException {  
				UserAccountClass_A e = new UserAccountClass_A();  
				e.setIdusers(rs.getInt(1));
				e.setUsername(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setGender(rs.getString(4));
				e.setFname(rs.getString(5));
				e.setLastname(rs.getString(6));
				e.setEmail(rs.getString(7));
				e.setIdaccounts(rs.getInt(8));
				e.setBalance(rs.getDouble(9));
				e.setAccountclosed(rs.getInt(11));
				return e;
			}
		}); 	
	}

	// GetuserBy Id
	public UserAccountClass_A getUserByIdAdminDB(int idaccounts) {  
		String sql = "select * from users u join accounts a where a.idusers = u.idusers AND a.idaccounts = ?;";
		return template.queryForObject(sql, new Object[]{idaccounts},new BeanPropertyRowMapper<UserAccountClass_A>(UserAccountClass_A.class));
	}

	// Save Edit User by Admin
	public UserAccountClass_A updateEditedUserByAdminDB(int idaccounts) {  
		String sql = "select * from users u join accounts a where a.idusers = u.idusers AND a.idaccounts = ?;";
		return template.queryForObject(sql, new Object[]{idaccounts},new BeanPropertyRowMapper<UserAccountClass_A>(UserAccountClass_A.class));
	}

	// Upodate Account for activating account
	public int activateDeactivateAccountDB (int accountId, int activateDeActivate) {
		String sql = "update accounts set accountclosed = " + activateDeActivate + " where idaccounts = " + accountId + ";";
		return template.update(sql);
	}
	
	
	// Fetch All Users
	public List<UserClass_A> getListAllUsersForAdmin() {  
		String sql="select * from users where idusers NOT IN (0, 7);";
		return template.query(sql, new RowMapper<UserClass_A>(){ 

			public UserClass_A mapRow(ResultSet rs, int row) throws SQLException {  
				UserClass_A e = new UserClass_A();  
				e.setIdusers(rs.getInt(1));
				e.setUsername(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setGender(rs.getString(4));
				e.setFname(rs.getString(5));
				e.setLastname(rs.getString(6));
				e.setEmail(rs.getString(7));
				return e;
			}
		}); 	
	}
	
	// POST Inserting a new row as the User Table happens
	public int RegisterNewUserTable(UserAccountClass_A u) {  
		String sql="insert into users(username, password, gender, fname, lastname, email) values('"+u.getUsername()+"','"+u.getPassword()+"','"+ u.getGender() +"', '"+ u.getFname() +"', '"+u.getLastname()+"', '"+ u.getEmail() +"')"; 
		return template.update(sql);  
	}
	
	public int fetchlastuserId() {
		String sql="SELECT Max(idusers) from users;"; 
		return template.queryForObject(sql, Integer.class);
	}
	
	// POST Inserting a new row as the Accounts Table happens
	public int RegisterNewAccountTable(UserAccountClass_A u, int userId) {  
		String sql="insert into accounts(balance, idusers) values("+u.getBalance()+","+ userId +")"; 
		return template.update(sql);  
	}
	
	public List<AccountClass_A> getListAllYourAccounts (String uname) {
		String sql="select * from accounts where accountclosed = 1 and idusers = (select idusers from users where username = '" + uname +"');";
		return template.query(sql, new RowMapper<AccountClass_A>(){ 

			public AccountClass_A mapRow(ResultSet rs, int row) throws SQLException {  
				AccountClass_A e = new AccountClass_A();  
				e.setIdaccounts(rs.getInt(1));
				e.setBalance(rs.getDouble(2));
				e.setIdusers(rs.getInt(3));
				e.setAccountclosed(rs.getInt(4));
				return e;
			}
		}); 
	}
	
	public List<TransactionClass_A> getListAllTransactions (int accountId) {
		String sql="select * from transactions t where t.senderAccountId =  "+ accountId +"  or t.receiverAccountId = " + accountId + ";";
		return template.query(sql, new RowMapper<TransactionClass_A>(){ 

			public TransactionClass_A mapRow(ResultSet rs, int row) throws SQLException {  
				TransactionClass_A e = new TransactionClass_A();  
				e.setIdtransactions(rs.getInt(1));
				e.setSenderAccountId(rs.getInt(2));
				e.setTransactionDate(rs.getString(3));
				e.setIdutilities(rs.getInt(4));
				e.setReceiverAccountId(rs.getInt(5));
				e.setTransactionsAmount(rs.getDouble(6));
				return e;
			}
		}); 
	}
}
