package com.nucleus.service;


import java.util.ArrayList;
import java.util.List;

import com.nucleus.dao.CustCrud;
import com.nucleus.model.Customer;

public class CustService 
{
	
CustCrud db=new CustCrud();

	

	public void insert(Customer c)  
	{
		try {
			db.insertdb(c);
		} 
		catch (Exception e) 
		{
			System.out.println("Inside custService insert()");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public void delete(String code) 
	{
		db.deletedb(code);
		
	}
	public Customer view(String code)
	{
		return db.viewdb(code);
	}
	public List<Customer> ViewAll()
	{
		List<Customer> list=new ArrayList<Customer>();
		list=db.ViewAll();
		System.out.println(list);
		return list;
		
	}
	public Customer viewupdate(String c)
	{
		return db.viewUpdate(c);
	}



	public void modify(Customer custobj) 
	{
		db.modifydb(custobj);
		
	}



	
}
