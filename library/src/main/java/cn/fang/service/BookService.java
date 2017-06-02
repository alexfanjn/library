package cn.fang.service;

import cn.fang.model.Book;

public interface BookService{
	//新增书籍
	public String addBook(Book book);

	//更新已有记录
	public String updateBook(Book book);
	
	//根据id删除书籍记录
	public String deleteBookById(int id);
}
