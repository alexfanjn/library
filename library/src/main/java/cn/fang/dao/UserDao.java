package cn.fang.dao;

import org.springframework.stereotype.Repository;

import cn.fang.model.Book;
import cn.fang.model.User;

@Repository
public interface UserDao
{
	//增加用户,即插入用户
	public boolean addUser(User user);
	
	//根据id计算count个数
	public int countById(int id);
	
	//根据id更新记录
	public int updateUserById(User user);
	
	//根据id删除记录
	public boolean deleteUsersById(String[] ids);
	
	//根据id获取对应用户的具体信息
	public User getUserById(int id);
}
