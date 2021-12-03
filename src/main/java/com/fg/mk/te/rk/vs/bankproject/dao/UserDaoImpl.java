package com.fg.mk.te.rk.vs.bankproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.fg.mk.te.rk.vs.bankproject.beans.UserClass_A;


public class UserDaoImpl implements UserDao {
	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {  
		this.template = template;  
	}

	public int RegisterLogin(UserClass_A p){  
		String sql="insert into users(username,password,gender,fname,lastname,email) values('"+p.getUsername()+"','"+p.getPassword()+"','"+p.getGender()+"','"+p.getFname()+"','"+p.getLastname()+"','"+p.getEmail()+"')"; 
		return template.update(sql);  
	}

	public UserClass_A validateUser(UserClass_A user) {

		String sql = "select * from users where username='" + user.getUsername() + "' and password='" + user.getPassword()
		+ "'";

		List<UserClass_A> users = template.query(sql, new UserMapper());
		
		

		return users.size() > 0 ? users.get(0) : null;
	}
}

class UserMapper implements RowMapper<UserClass_A> {

	public UserClass_A mapRow(ResultSet rs, int arg1) throws SQLException {
		UserClass_A user = new UserClass_A();  
		user.setIdusers(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setPassword(rs.getString(3)); 
		user.setGender(rs.getString(4));
		user.setFname(rs.getString(5));
		user.setLastname(rs.getString(6));
		user.setEmail(rs.getString(7));
		return user;
	}
}