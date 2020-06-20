package org.user.service;

import org.user.dao.UserDao;
import org.user.entity.User;

//业务逻辑层：逻辑性的增删改查（增：查+增），对dao层进行组装
public class UserService {
	UserDao userDao=new UserDao();
	
	
	public boolean addUser(User user) {
		if(!userDao.isExist(user.getUname())) {
			userDao.addUser(user);
			return true;
		}else {
			System.out.println("此人已存在！");
			return false;
		}
	}
}
