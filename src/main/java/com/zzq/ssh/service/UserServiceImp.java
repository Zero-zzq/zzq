package com.zzq.ssh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzq.ssh.dao.IUserDao;
import com.zzq.ssh.model.User;

@Transactional(rollbackFor=java.lang.Exception.class)
@Service("userServiceImp")
public class UserServiceImp implements IUserService {

	@Resource(name="userDaoImp")
	private IUserDao userDao;
	
	
	public void add() {
		User user = new User();
		user.setUserId(1);
		user.setUserName("admin");
		userDao.add(user);
	}


	public void queryList() {
		List<User> querylist = userDao.querylist();
		System.out.println(querylist.get(0).getUserId());
		System.out.println(querylist.get(0).getUserName());
	}
	//要保证事物的一致，如转钱中途报错，要保证程序继续运行
	public void addTwo(int i) throws Exception{
		User user = new User();
		user.setUserId(4);
		user.setUserName("admin");
		userDao.add(user);
		if (i==1) {
			throw new RuntimeException();
		}
		User user2 = new User();
		user2.setUserId(3);
		user2.setUserName("admin");
		userDao.add(user2);
	}
}
