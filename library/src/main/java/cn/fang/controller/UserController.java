package cn.fang.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fang.model.User;
import cn.fang.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController
{
	@Resource
	public UserService userService;
	
	//新增用户
	@RequestMapping(value="/addUser.do",method=RequestMethod.POST)
	@ResponseBody
	public String addUser(User user)
	{
		return userService.addUser(user);
	}
	
}
