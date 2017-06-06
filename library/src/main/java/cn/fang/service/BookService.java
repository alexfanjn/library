package cn.fang.service;

import java.util.List;

import cn.fang.model.Book;

public interface BookService{
	//新增书籍
	public String addBook(Book book);

	//更新已有记录
	public String updateBook(Book book);
	
	//根据id删除书籍记录
	public String deleteBookById(String[] id);
	
	//根据id获得某个书籍的具体信息
	public Book getBookById(int id);
	
	//根据页数获取书籍信息list
	public List<Book> getBooks(int page);
	
	
	//还书
	public String returnBook(int id);
}
