package cn.fang.dao;

import cn.fang.model.Borrow;

public interface BorrowDao
{
	//插入新纪录
	public int insert(Borrow borrow);
	
	//根据id修改对应书籍的isBorrow
	public int updateStatusById(int id);
	
	//根据id批量删除借书记录
	public boolean deleteBorrowsById(String[] ids);
}
