package cn.fang.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fang.model.Book;
import cn.fang.service.BookService;
import cn.fang.service.imp.BookServiceImp;

@Controller
@RequestMapping("/book")
public class BookController{
	@Resource
	public BookService bookService;
	
	//新增书籍
	@RequestMapping(value="/addBook",method=RequestMethod.POST)
	@ResponseBody
	public String addBook(Book book){
		return bookService.addBook(book);
	}
	
	//修改书籍参数
	@RequestMapping(value="/updateBook",method=RequestMethod.POST)
	@ResponseBody
	public String updateBook(Book book){
		return bookService.updateBook(book);
	}
	
	//此处应为什么方法?????
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteBook(@RequestParam int id){
		return bookService.deleteBookById(id);
	}
}
