package cn.fang.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fang.service.DataTableService;

@Controller
@RequestMapping("/DataTableController")
public class DataTableController
{

	@Autowired(required = false)
	private DataTableService dataTableService;

	@RequestMapping(value = "/getListForPage.do", method = RequestMethod.POST)
	@ResponseBody
	public Map getTableListForPage(String statement, String aoData, String param) throws Exception
	{
		Map value = dataTableService.getData(statement, aoData, param);
		return value;
	}

}
