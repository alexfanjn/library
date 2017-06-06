package cn.fang.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.fang.model.Book;
import cn.fang.model.User;
import cn.fang.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController
{
	@Resource
	public UserService userService;
	
	@RequestMapping("/showuser.do")
	public ModelAndView showbook(@RequestParam("id") Integer id)
	{
		ModelAndView mv = new ModelAndView("/module/user/user-update.jsp");
		User user = userService.getUserById(id);
		mv.addObject("user", user);
		return mv;
	}
	
	
	//新增用户
	@RequestMapping(value="/addUser.do",method=RequestMethod.POST)
	@ResponseBody
	public String addUser(User user)
	{
		return userService.addUser(user);
	}
	
	// 修改用户参数
	@RequestMapping(value = "/updateUser.do", method = RequestMethod.POST)
	@ResponseBody
	public String updateUser(User user)
	{
		return userService.updateUser(user);
	}
	
	// 根据id删除用户&&批量删除
	@RequestMapping(value = "/deleteUser.do", method = RequestMethod.GET)
	@ResponseBody
	public String deleteUser(@RequestParam(value = "ids", required = true) String ids)
	{
		String[] idsArg = ids.split(",");
		return userService.deleteUsersById(idsArg);
	}
}
