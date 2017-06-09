package cn.fang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController
{
	//登录检验
	@RequestMapping(value="/test.do",method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam String id,@RequestParam String password)
	{
		System.out.println("账号密码分别为"+id+"   "+password);
		//假定账号密码均为admin
		if(id.equals("admin")&&password.equals("admin"))
			//登录成功
			return "200";
		//登录失败
		return "300";
	}
}
