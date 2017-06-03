package cn.fang.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fang.model.Book;
import cn.fang.service.BookService;

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
	//根据id删除书籍
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteBook(@RequestParam int id){
		return bookService.deleteBookById(id);
	}
	
	//获取单个书籍的详细信息
	@RequestMapping(value="/getSingleBook",method=RequestMethod.GET)
	@ResponseBody
	public Book getSingleBook(@RequestParam int id){
		Book book = new Book();
		book = bookService.getBookById(id);
		return book;
	}
	
	//根据页数获取书籍相关信息
	@RequestMapping(value="/getBookByPage",method=RequestMethod.GET)
	@ResponseBody
	public List<Book> getBooks(@RequestParam int page){
		List<Book> books = new ArrayList<>();
		books = bookService.getBooks(page);
		return books;
	}
}
