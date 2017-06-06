package cn.fang.service;

import cn.fang.model.Book;
import cn.fang.model.User;

public interface UserService
{
	//新增用户
	public String addUser(User user);
	
	//更新已有记录
	public String updateUser(User user);
	
	//根据id删除书籍记录
	public String deleteUsersById(String[] id);
	
	//根据id获得某个书籍的具体信息
	public User getUserById(int id);
}
