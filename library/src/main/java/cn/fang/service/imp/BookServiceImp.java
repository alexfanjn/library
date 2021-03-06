package cn.fang.service.imp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.fang.dao.BookDao;
import cn.fang.model.Book;
import cn.fang.service.BookService;

@Service
public class BookServiceImp implements BookService
{
	@Resource
	private BookDao bookDao;

	@Override
	public String addBook(Book book)
	{
		// 获取系统当前时间，用做于当前记录创建时间
		book.setCreateTime(new Date());
		System.out.println(book.getCreateTime());
		// 默认设置新加入的书籍为未借出即false。
		book.setIsBorrow(false);
		boolean tag = bookDao.addBook(book);
		if (tag == false)// 新增失败
			return "300";
		return "200";// 新增成功

	}

	@Override
	public String updateBook(Book book)
	{
		// 首先根据id查看是否有此条记录
		int count = bookDao.countById(book.getId());
		if (count == 0)
			// 未找到此记录
			return "301";
		// 找到id为book.id的记录
		// 通过update更新此条记录
		int count1 = bookDao.updateBookById(book);
		if (count1 == 1)
			// 修改成功
			return "200";
		// 服务器出错
		return "500";
	}

	/*
	@Override
	public String deleteBookById(String[] id)
	{
		// 首先根据id查找是否有对应记录
		int count = bookDao.countById(id);
		if (count == 0)
			// 未找到对应记录
			return "301";
		// 找到对应记录
		int count1 = bookDao.deleteBookById(id);
		if (count1 == 1)
			// 删除成功
			return "200";
		// 服务器出错
		return "500";
	}
	*/
	public String deleteBookById(String[] ids)
	{
		if (bookDao.deleteBookById(ids))
		{
			return "200";
		}else{
			return "500";
		}
	}

	// 根据id获取书籍
	@Override
	public Book getBookById(int id)
	{
		return bookDao.getBookById(id);
	}

	@Override
	public String returnBook(int id)
	{
		int tag = bookDao.uodateBookStatusById(id,0);
		if(tag == 1)
			return "200";
		return "300";
	}

}
