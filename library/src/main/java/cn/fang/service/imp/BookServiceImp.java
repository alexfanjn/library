package cn.fang.service.imp;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.fang.dao.BookDao;
import cn.fang.model.Book;
import cn.fang.service.BookService;

@Service
public class BookServiceImp implements BookService{
	@Resource
	private BookDao bookDao;

	public String addBook(Book book){
		//获取系统当前时间，用做于当前记录创建时间
		book.setCreateTime(new Date());
		System.out.println(book.getCreateTime());
		//默认设置新加入的书籍为未借出即false。
		book.setIsBorrow(false);
		boolean tag = bookDao.addBook(book);
		if(tag == false)//新增失败
			return "300";
		return "200";//新增成功
		
	}
	
}
