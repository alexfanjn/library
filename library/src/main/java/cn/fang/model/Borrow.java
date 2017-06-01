package cn.fang.model;

import java.sql.Date;

public class Borrow
{
	//书籍id
	private int bookId;
	
	//用户id
	private int userId;
	
	//借书日期
	private Date outDate;
	
	//记录创建时间
	private Date createTime;

	public int getBookId()
	{
		return bookId;
	}

	public void setBookId(int bookId)
	{
		this.bookId = bookId;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public Date getOutDate()
	{
		return outDate;
	}

	public void setOutDate(Date outDate)
	{
		this.outDate = outDate;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
}
