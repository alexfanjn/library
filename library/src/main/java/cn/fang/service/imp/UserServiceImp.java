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

}
