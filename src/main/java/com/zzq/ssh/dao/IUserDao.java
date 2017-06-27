package com.zzq.ssh.dao;


import java.util.List;

import com.zzq.ssh.model.User;

public interface IUserDao {

	public void add(User user);
	
	public List<User> querylist();
}
