package cn.fang.service;

import cn.fang.model.Borrow;

public interface BorrowService
{
	//新增借书信息
	public String addBorrow(Borrow borrow);
	
	//批量删除
	public String deleteBorrowsById(String[] ids);
}
