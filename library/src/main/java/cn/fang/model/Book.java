package cn.fang.model;

import java.sql.Date;

public class Book
{
	//书籍id
	private int id;
	
	//书籍名字
	private String bookName;
	
	//书籍存放位置
	private String location;
	
	//是否已借
	private boolean isBorrow;
	
	//记录创建时间
	private Date createTime;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getBookName()
	{
		return bookName;
	}

	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public boolean isIsBorrow()
	{
		return isBorrow;
	}

	public void setIsBorrow(boolean isBorrow)
	{
		this.isBorrow = isBorrow;
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
