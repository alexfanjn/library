package cn.fang.service.imp;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.fang.dao.UserDao;
import cn.fang.model.User;
import cn.fang.service.UserService;

@Service
public class UserServiceImp implements UserService
{
	@Resource
	public UserDao userDao;

	@Override
	public String addUser(User user)
	{
		// 获取系统当前时间，用做于当前记录创建时间
		user.setCreateTime(new Date());
		System.out.println(user.getCreateTime());
		boolean tag = userDao.addUser(user);
		if (tag == false)// 新增失败
			return "300";
		return "200";// 新增成功
	}

	@Override
	public String updateUser(User user)
	{
		// 首先根据id查看是否有此条记录
		int count = userDao.countById(user.getId());
		if (count == 0)
			// 未找到此记录
			return "301";
		// 找到id为book.id的记录
		// 通过update更新此条记录
		int count1 = userDao.updateUserById(user);
		if (count1 == 1)
			// 修改成功
			return "200";
		// 服务器出错
		return "500";
	}
	
	public String deleteUserById(String[] ids)
	{
		if (userDao.deleteUsersById(ids))
		{
			return "200";
		}else{
			return "500";
		}
	}

}
