package cn.fang.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.fang.model.Book;
import cn.fang.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController
{
	@Resource
	public BookService bookService;

	@RequestMapping("/showbook.do")
	public ModelAndView showbook(@RequestParam("id") Integer id)
	{
		ModelAndView mv = new ModelAndView("/module/book/book-update.jsp");
		Book book = bookService.getBookById(id);
		mv.addObject("book", book);
		return mv;
	}

	// 新增书籍
	@RequestMapping(value = "/addBook.do", method = RequestMethod.POST)
	@ResponseBody
	public String addBook(Book book)
	{
		return bookService.addBook(book);
	}

	// 修改书籍参数
	@RequestMapping(value = "/updateBook.do", method = RequestMethod.POST)
	@ResponseBody
	public String updateBook(Book book)
	{
		return bookService.updateBook(book);
	}

	// 根据id删除书籍
	@RequestMapping(value = "/deleteBook.do", method = RequestMethod.GET)
	@ResponseBody
	public String deleteBook(@RequestParam(value = "ids", required = true) String ids)
	{
		String[] idsArg = ids.split(",");
		return bookService.deleteBookById(idsArg);
	}

	// 获取单个书籍的详细信息
	@RequestMapping(value = "/getSingleBook", method = RequestMethod.GET)
	@ResponseBody
	public Book getSingleBook(@RequestParam int id)
	{
		Book book = new Book();
		book = bookService.getBookById(id);
		return book;
	}
	
	//根据id修改书籍的  status
	@RequestMapping(value = "/updateBookStatus", method = RequestMethod.GET)
	@ResponseBody
	public String updateBookStatusById(int id)
	{
		return bookService.returnBook(id);
	}
}
