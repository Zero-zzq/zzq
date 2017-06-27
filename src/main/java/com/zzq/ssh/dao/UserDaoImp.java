package com.zzq.ssh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zzq.ssh.model.User;

@Repository("userDaoImp")
public class UserDaoImp implements IUserDao {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<User> userMapper = new RowMapper<User>() {

		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			user.setUserId(rs.getInt("user_id"));
			user.setUserName(rs.getString("user_name"));
			return user;
		}
	};
	
	public void add(User user) {
		String sql = "insert into User(userId,userName) value("+user.getUserId()+",'"+user.getUserName()+"')";
		jdbcTemplate.execute(sql);
	}


	public List<User> querylist() {
		//String sql = "select * from User";
		String sql = "select userId user_id,userName user_name from User";
		//List<User> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
		List<User> list = jdbcTemplate.query(sql,userMapper);
		return list;
	}

}
