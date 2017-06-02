package cn.fang.dao;

import cn.fang.model.Book;

public interface BookDao
{
	//增加书籍,即插入书籍
	public boolean addBook(Book book);
	
	//根据id计算count个数
	public int countById(int id);
	
	//根据id更新记录
	public int updateBookById(Book book);
	
}
