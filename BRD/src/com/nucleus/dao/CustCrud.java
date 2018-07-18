package com.nucleus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.nucleus.connection.ConnectionInterface;
import com.nucleus.connection.FactoryClass;
import com.nucleus.model.Customer;

public class CustCrud
{
	GregorianCalendar calobj = new GregorianCalendar();
	String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	int day = calobj.get(Calendar.DATE);
	String month = months[calobj.get(Calendar.MONTH)];
	int year = calobj.get(Calendar.YEAR);
	
	String date = day + "/" + month + "/" + year;
	
	public Connection con=null;
	PreparedStatement pst= null;
	ResultSet rs=null;
			
		public void insertdb(Customer custobj) throws Exception 
		{
			
			
		      //getCon();
			FactoryClass fc = new FactoryClass();
			ConnectionInterface cc = fc.factoryMethod("oracle");
			con = cc.getConnection();
				try
				{
					//(CustomerId, CustomerCode, CustomerName, CustomerAddress1, CustomerAddress2, CustomerPinCode, EmailAddress, ContactNumber, PrimaryContactPerson, RecordStatus, Flag, CreateDate, CreatedBy,ModifiedDate, ModifiedBy, AuthorizedDate, AuthorizedBy)
					System.out.println("Validation at server side completed successfully");
				//(CustomerCode, CustomerName, CustomerAddress1, CustomerAddress2, CustomerPinCode, EmailAddress, ContactNumber, PrimaryContactPerson, RecordStatus, Flag, CreateDate, CreatedBy)
				String sql = "Insert into CUSTOMERMASTER23 values(Custid001.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				System.out.println("Inserting rows into database.........");
				pst = con.prepareStatement(sql);
				System.out.println("After the query statement");
				pst.setInt(1, custobj.getId());
				pst.setString(1, custobj.getCode());
				pst.setString(2, custobj.getName());
				pst.setString(3, custobj.getAddress1());
				pst.setString(4, custobj.getAddress2());
				pst.setLong(5, Long.parseLong(custobj.getPincode()));
				pst.setString(6, custobj.getEmail());
				pst.setLong(7, Long.parseLong(custobj.getContact()));
				pst.setString(8, custobj.getPcp());
				pst.setString(9, "N");
				pst.setString(10, custobj.getFlag());
				pst.setString(11, date);
				pst.setString(12, custobj.getUname());
				pst.setString(13,custobj.getModifiedDate());
				pst.setString(14,custobj.getModifiedBy());
				pst.setString(15,date);
				pst.setString(16,"Anchal Sachdeva");
						
				pst.executeUpdate();
				System.out.println("Rows are inserted in database");
				}
				catch(java.sql.SQLException e1)
				{
					System.out.println("Same ID already exists");
				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
				
				con.commit();
				con.close();
			
			}
	/*
	public void insertdb (Customer custobj)
	{
		Configuration config = new Configuration();
		config.configure();//populates the data of configuraton file
		
		SessionFactory sFactory=config.buildSessionFactory();
		
		Session session= sFactory.openSession();
		
		Transaction t= session.beginTransaction();
		session.persist(custobj);
		t.commit();
		session.close();
	}*/
	
	
	
	
		public void deletedb(String c)
		{
			FactoryClass fc = new FactoryClass();
			ConnectionInterface cc = fc.factoryMethod("oracle");
			con = cc.getConnection();
			//getCon();
			
			try
			{
				System.out.println("In deleteDB try");
				String sql="Delete from CustomerMaster23 where CustomerCode=?";
				pst=con.prepareStatement(sql);
				pst.setString(1, c);
				System.out.println("Code set");
				@SuppressWarnings("unused")
				int x=pst.executeUpdate();
				System.out.println("Update done");
				System.out.println("Record deleted");
			
			}
			catch(Exception e)
			{
				System.out.println("inside delete catch");
				e.printStackTrace();
			}
		}
		public Customer viewdb(String code)
		{
			
			
			Customer cust=new Customer();
			FactoryClass fc = new FactoryClass();
			ConnectionInterface cc = fc.factoryMethod("oracle");
			con = cc.getConnection();
			//getCon();
				
			try
			{
				String s="Select * from CustomerMaster23 where CustomerCode=";
				String query=s.concat(code);
				System.out.println(query);
				/*String sql="Select * from CustomerMaster23 where Customer_Code=?";*/
				pst=con.prepareStatement(query);
				System.out.println("Query Prepared");
				ResultSet rs=pst.executeQuery(query);
				System.out.println("Result set is "+rs);
				
				while(rs.next())
				{
					/*String i1=rs.getString(1);
					String i2=rs.getString(2);
					String i3=rs.getString(3);
					String i4=rs.getString(4);
					String i5=rs.getString(5);
					String i6=rs.getString(6);
					String i7=rs.getString(7);
					String i8=rs.getString(8);
					String i9=rs.getString(9);
					String i10=rs.getString(10);
					String i11=rs.getString(11);
					String i12=rs.getString(12);
					
					detail=i1+"::"+i2+"::"+i3+"::"+i4+"::"+i5+"::"+i6+"::"+i7+"::"+i8+"::"+i9+"::"+i10+"::"+i11+"::"+i12;*/
					
					System.out.println("Inside while of viewdb");
					System.out.println("Testing ................."+rs.getString(1));
					System.out.println("Testing........"+rs.getString(2));
					cust.setCode(rs.getString(2));
					cust.setName(rs.getString(3));
					cust.setAddress1(rs.getString(4));
					cust.setAddress2(rs.getString(5));
					cust.setPincode(rs.getString(6));
					cust.setEmail(rs.getString(7));
					cust.setContact(rs.getString(8));
					cust.setPcp(rs.getString(9));
					cust.setRecord(rs.getString(10));
					cust.setFlag(rs.getString(11));
					cust.setCreateDate(rs.getString(12));
					cust.setCreatedBy(rs.getString(13));
					cust.setModifiedDate(rs.getString(14));
					cust.setModifiedBy(rs.getString(15));
					cust.setAuthorizedDate(rs.getString(16));
					cust.setAuthorizedBy(rs.getString(17));
					System.out.println(cust.toString());
				}	
			}
			
			catch(Exception e)
			{
				System.out.println("Inside ViewDb in dao Catch");
				e.printStackTrace();
			}
			return cust;

		}
		public List <Customer> ViewAll()
		{
			FactoryClass fc = new FactoryClass();
			ConnectionInterface cc = fc.factoryMethod("oracle");
			con = cc.getConnection();
			
			//getCon();
			List <Customer> list=new ArrayList<Customer>();
				
			try
			{
				pst=con.prepareStatement("Select * from CustomerMaster23");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Customer u=new Customer();
					  u.setId(Integer.parseInt(rs.getString(1)));
			          u.setCode(rs.getString(2));
			            u.setName(rs.getString(3));
			            u.setAddress1(rs.getString(4));
			            u.setAddress2(rs.getString(5));
			            u.setPincode(rs.getString(6));
			            u.setEmail(rs.getString(7));
			            u.setContact(rs.getString(8));
			            u.setPcp(rs.getString(9));
			            u.setRecord(rs.getString(10));
			            u.setFlag(rs.getString(11));
			            u.setCreateDate(rs.getString(12));
			            u.setCreatedBy(rs.getString(13));
			            u.setModifiedDate(rs.getString(14));
			            u.setModifiedBy(rs.getString(15));
			            u.setAuthorizedDate(rs.getString(16));
			            u.setAuthorizedBy(rs.getString(17));
			            list.add(u);  
			           /* System.out.println("Add");
			            System.out.println("The values of customers from viewdb="+u.toString());*/
			        }  
			    }
			catch(Exception e)
			{
				System.out.println(e);
		    }  
		    return list; 
   }
		public Customer viewUpdate(String code)
		{
			FactoryClass fc = new FactoryClass();
			ConnectionInterface cc = fc.factoryMethod("oracle");
			con = cc.getConnection();
			//getCon();
			Customer cust=new Customer();
			try
			{
				String s="Select * from CustomerMaster23 where CustomerCode=";
				String query=s.concat(code);
				System.out.println(query);
				pst=con.prepareStatement(query);
				System.out.println("Query prepared");
				ResultSet rs=pst.executeQuery();
				System.out.println(rs);
				while(rs.next())
				{
					/*System.out.println("Inside while of updateVieew");
					System.out.println("Testing ................."+rs.getString(1));
					System.out.println("Testing........"+rs.getString(2));*/
					cust.setCode(rs.getString(2));
					cust.setName(rs.getString(3));
					cust.setAddress1(rs.getString(4));
					cust.setAddress2(rs.getString(5));
					cust.setPincode(rs.getString(6));
					cust.setEmail(rs.getString(7));
					cust.setContact(rs.getString(8));
					cust.setPcp(rs.getString(9));
					cust.setRecord(rs.getString(10));
					cust.setFlag(rs.getString(11));
					cust.setCreateDate(rs.getString(12));
					cust.setCreatedBy(rs.getString(13));
					System.out.println(cust.toString());
				}	
			}
			
			catch(Exception e)
			{
				System.out.println("Inside ViewQuery Catch");
				e.printStackTrace();
			}
			return cust;			
			
			
		}

		public void modifydb(Customer custobj) 
		{
			System.out.println(custobj);
			FactoryClass fc = new FactoryClass();
			ConnectionInterface cc = fc.factoryMethod("oracle");
			con = cc.getConnection();
			try
			{
			System.out.println("Validation at server side completed successfully");
			String sql = "Update CUSTOMERMASTER23 set CustomerName=?, CustomerAddress1=?, CustomerAddress2=?, CustomerPinCode=?, EmailAddress=?, ContactNumber=?, PrimaryContactPerson=?, RecordStatus=?, Flag=? , ModifiedDate=?, ModifiedBy=? where CustomerCode=?";
			custobj.setModifiedDate(date);
			custobj.setModifiedBy("Anchal");
			System.out.println("Inserting rows into database.........");
			pst = con.prepareStatement(sql);
			System.out.println("After the query statement");
			pst.setString(1, custobj.getName());
			pst.setString(2, custobj.getAddress1());
			pst.setString(3, custobj.getAddress2());
			pst.setLong(4, Long.parseLong(custobj.getPincode()));
			pst.setString(5, custobj.getEmail());
			pst.setLong(6, Long.parseLong(custobj.getContact()));
			pst.setString(7, custobj.getPcp());
			pst.setString(8, "M");
			pst.setString(9, custobj.getFlag());
			pst.setString(10,custobj.getModifiedDate());
			pst.setString(11,custobj.getModifiedBy());
			pst.setString(12, custobj.getCode());
					
			pst.executeUpdate();
			System.out.println("Rows are inserted in database");
			con.commit();
			con.close();
		
		}
			catch(Exception e)
			{
				System.out.println("Error in modify");
				e.printStackTrace();
			}
}
}

			
			
		
		
		
	


