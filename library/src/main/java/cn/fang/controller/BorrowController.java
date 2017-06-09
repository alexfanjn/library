package cn.fang.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fang.model.Borrow;
import cn.fang.service.BorrowService;

@Controller
@RequestMapping(value="/borrow")
public class BorrowController
{
	@Resource
	public BorrowService borrowService;
	
	
	@RequestMapping(value="/addBorrow.do",method=RequestMethod.POST)
	@ResponseBody
	public String addBorrow(Borrow borrow){
		return borrowService.addBorrow(borrow);
	}
	
	@RequestMapping(value="/deleteBorrow.do",method=RequestMethod.GET)
	@ResponseBody
	public String deleteBorrow(@RequestParam(value = "ids", required = true) String ids){
		String[] idsArg = ids.split(",");
		return borrowService.deleteBorrowsById(idsArg);
	}
	
}
