package com.nucleus.service;


import com.nucleus.dao.UserCrud;

public class UserService 
{
	UserCrud db=new UserCrud();
	public String Finddb(String u,String p)
	{
		String role=db.FindDB(u,p);
		return role;
	}
	

}
