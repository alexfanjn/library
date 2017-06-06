package cn.fang.service;

import cn.fang.model.Book;
import cn.fang.model.User;

public interface UserService
{
	//新增用户
	public String addUser(User user);
	
	//更新已有记录
	public String updateUser(User user);
}
