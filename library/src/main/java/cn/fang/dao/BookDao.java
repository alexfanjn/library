package cn.fang.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.fang.model.Book;

@Repository
public interface BookDao
{
	//增加书籍,即插入书籍
	public boolean addBook(Book book);
	
	//根据id计算count个数
	public int countById(int id);
	
	//根据id更新记录
	public int updateBookById(Book book);
	
	//根据id更改书籍状态
	public int uodateBookStatusById(int id,int status);
	
	//根据id删除记录
	public boolean deleteBookById(String[] ids);
	
	//根据id获取对应书籍的具体信息
	public Book getBookById(int id);
	
	//根据记录的起始条数count获取书籍list的相关信息
	public List<Book> getBooks(int count);
}
