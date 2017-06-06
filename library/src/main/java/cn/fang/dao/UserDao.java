package cn.fang.dao;

import org.springframework.stereotype.Repository;

import cn.fang.model.User;

@Repository
public interface UserDao
{
	//增加用户,即插入用户
	public boolean addUser(User user);
}
