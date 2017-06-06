package cn.fang.service.imp;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.fang.dao.BookDao;
import cn.fang.dao.BorrowDao;
import cn.fang.model.Borrow;
import cn.fang.service.BorrowService;

@Service
public class BorrowServiceImp implements BorrowService
{
	@Resource
	private BorrowDao borrowDao;
	@Resource
	private BookDao bookDao;
	
	@Override
	public String addBorrow(Borrow borrow)
	{
		//获取系统当前时间
		borrow.setCreateTime(new Date());
		borrow.setOutDate(new Date());
		//向borrow表中扎入该记录--------采用联合主键---有个bug：不能再次借同一本书
		int tag = borrowDao.insert(borrow);
		if(tag == 1){
			//插入成功
			//将书籍状态改为  已借出
			bookDao.uodateBookStatusById(borrow.getBookId(),1);
			return "200";
		}else {
			//插入失败
			return "301";
		}
	}

}
