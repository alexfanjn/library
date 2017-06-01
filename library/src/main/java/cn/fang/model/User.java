package cn.fang.model;

import java.sql.Date;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class User
{
	//学生id
	private int id;
	
	//学生姓名
	private String name;
	
	//学生专业
	private String major;
	
	//学生班级
	private int userClass;
	
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getMajor()
	{
		return major;
	}

	public void setMajor(String major)
	{
		this.major = major;
	}

	public int getUserClass()
	{
		return userClass;
	}

	public void setUserClass(int userClass)
	{
		this.userClass = userClass;
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
