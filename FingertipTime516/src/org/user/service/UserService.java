package org.user.service;

import org.user.dao.UserDao;
import org.user.entity.User;

//ҵ���߼��㣺�߼��Ե���ɾ�Ĳ飨������+��������dao�������װ
public class UserService {
	UserDao userDao=new UserDao();
	
	
	public boolean addUser(User user) {
		if(!userDao.isExist(user.getUname())) {
			userDao.addUser(user);
			return true;
		}else {
			System.out.println("�����Ѵ��ڣ�");
			return false;
		}
	}
}
