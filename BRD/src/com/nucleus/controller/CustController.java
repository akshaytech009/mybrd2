package com.nucleus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.model.Customer;
import com.nucleus.service.CustService;
import com.nucleus.validation.Servervalidation;


@WebServlet("/CustController")

public class CustController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CustController() 
    {
        super();
    }
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String button=request.getParameter("button");
		PrintWriter out=response.getWriter();
		out.print(button);
	
		HttpSession session=request.getSession(false);
		@SuppressWarnings("unused")
		String user=(String)session.getAttribute("user");
		if(((String)session.getAttribute("user"))!=null)
		if(button.equalsIgnoreCase("update"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("Update1.jsp");
			rd.forward(request, response);
		}
		else if(button.equalsIgnoreCase("retrieve"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("Retrieve1.jsp");
			rd.forward(request, response);
		}
		if(button.equalsIgnoreCase("ViewAll"))
		{
			CustService cs=new CustService();
			List<Customer> list =cs.ViewAll();
			request.setAttribute("list", list);
			RequestDispatcher rd=request.getRequestDispatcher("ViewAll1.jsp");
			rd.forward(request, response);
		}
		else if(button.equalsIgnoreCase("sawDetails"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("options1.jsp");
			rd.forward(request, response);
		}
		else if(button.equalsIgnoreCase("okay"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("options1.jsp");
			rd.forward(request, response);
		}
			
	
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		GregorianCalendar calobj = new GregorianCalendar();
		String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		int day = calobj.get(Calendar.DATE);
		String month = months[calobj.get(Calendar.MONTH)];
		int year = calobj.get(Calendar.YEAR);
		
		String date = day + "/" + month + "/" + year;
		
		
		/*System.out.println("User name from CustController is"+user);*/
		
		String button1=request.getParameter("button1");
		System.out.println("Button is : "+button1);
		PrintWriter out=response.getWriter();
		CustService cs=null;
		 HttpSession session=request.getSession(false);  
		String user=(String)session.getAttribute("user");  

		
		if(button1.equalsIgnoreCase("insert"))
		{
			Customer custobj=new Customer();
			Customer c2=new Customer();
			
			
			@SuppressWarnings("unused")
			String message = "Your form has been successfully Submitted";
			custobj.setCode(request.getParameter("code"));
			System.out.println(custobj.getCode());
			custobj.setName(request.getParameter("name"));
			System.out.println(custobj.getName());
			custobj.setAddress1(request.getParameter("address1"));
			System.out.println(custobj.getAddress1());
			custobj.setAddress2(request.getParameter("address2"));
			System.out.println(custobj.getAddress2());
			custobj.setPincode(request.getParameter("pincode"));
			System.out.println(custobj.getPincode());
			custobj.setEmail(request.getParameter("email"));
			System.out.println(custobj.getEmail());
			custobj.setContact(request.getParameter("contact"));
			System.out.println(custobj.getContact());
			custobj.setPcp(request.getParameter("pcp"));
			System.out.println(custobj.getPcp());
			custobj.setFlag(request.getParameter("dropdown"));
			System.out.println(custobj.getFlag());
			custobj.setUname(user);
			System.out.println(custobj.getUname());
			
			Servervalidation sv=new Servervalidation();
			boolean valid=sv.validate(custobj);
			if(valid)
			{
			    	
				cs=new CustService();
				CustService cs1=new CustService();
				try {
					c2=cs1.view(custobj.getCode());
					System.out.println("From custcontroller value of c2"+c2);
					if(c2.getCode()==null)
					{
					cs.insert(custobj);
					System.out.println("Inserted from cust controller");
					RequestDispatcher rd=request.getRequestDispatcher("options1.jsp");
					rd.forward(request, response);
					}
					else
					{
						out.print("Duplicate customer code found");
						RequestDispatcher rd=request.getRequestDispatcher("options1.jsp");
						rd.include(request, response);
					}
				} 
				catch (Exception e) 
				{
					System.out.println("Something's fishy");
					e.printStackTrace();
				}
			    	
			}
			else
			{
				System.out.println("Validation Failed at Server Side");
				out.print("Validation Failed at server side");
				RequestDispatcher rd=request.getRequestDispatcher("options1.jsp");
				rd.include(request, response);
			}
			
	    }
		else if(button1.equalsIgnoreCase("logout"))
		{
			
			session.invalidate();
			response.setContentType("text/html");
	    	RequestDispatcher rd=request.getRequestDispatcher("UserLogin.jsp");
	    	rd.forward(request, response);
		}
		else if(button1.equalsIgnoreCase("delete"))
		{
				response.setContentType("text/html");
		    	@SuppressWarnings("unused")
				PrintWriter out1=response.getWriter();
				String code=request.getParameter("code");
				System.out.println("code from CustController="+code);
				cs=new CustService();
				cs.delete(code);
				response.sendRedirect("options1.jsp");
			
			
		}
		else if(button1.equalsIgnoreCase("retrieve"))
		{
			response.setContentType("text/html");
			String code=request.getParameter("code");
			cs=new CustService();
			Customer cust=cs.view(code);
			System.out.println("Customer object recieved from Srvice with details="+cust.toString());
			request.setAttribute("cust", cust);
			RequestDispatcher rd=request.getRequestDispatcher("ViewOne1.jsp");
			rd.forward(request, response);
		}
		else if(button1.equalsIgnoreCase("update"))
		{
			response.setContentType("text/html");
			String code=request.getParameter("code");
			cs=new CustService();
			Customer cust=cs.viewupdate(code);
			System.out.println("Customer object recieved from Srvice with details="+cust.toString());
			request.setAttribute("cust", cust);
			RequestDispatcher rd=request.getRequestDispatcher("UpdateForm1.jsp");
			rd.forward(request, response);
		}
		else if(button1.equalsIgnoreCase("update2"))
		{
			response.setContentType("text/html");
			System.out.println("Congo you're inside update 2");
            Customer custobj=new Customer();
			custobj.setCode(request.getParameter("code"));
			System.out.println(custobj.getCode());
			custobj.setName(request.getParameter("name"));
			System.out.println(custobj.getName());
			custobj.setAddress1(request.getParameter("address1"));
			System.out.println(custobj.getAddress1());
			custobj.setAddress2(request.getParameter("address2"));
			System.out.println(custobj.getAddress2());
			custobj.setPincode(request.getParameter("pincode"));
			System.out.println(custobj.getPincode());
			custobj.setEmail(request.getParameter("email"));
			System.out.println(custobj.getEmail());
			custobj.setContact(request.getParameter("contact"));
			System.out.println(custobj.getContact());
			custobj.setPcp(request.getParameter("pcp"));
			System.out.println(custobj.getPcp());
			custobj.setFlag(request.getParameter("dropdown"));
			System.out.println(custobj.getFlag());
			System.out.println(custobj.getUname());
			
			Servervalidation sv=new Servervalidation();
			boolean valid=sv.validate(custobj);
			if(valid)
			{
			    	
				cs=new CustService();
				try {
					custobj.setModifiedDate(date);
					custobj.setModifiedBy(user);
					System.out.println(custobj);
					cs.modify(custobj);
					RequestDispatcher rd=request.getRequestDispatcher("options1.jsp");
					rd.forward(request, response);
				} 
				catch (Exception e) 
				{
					System.out.println("Something's fishy");
					e.printStackTrace();
				}
			    	
			}
			else
			{
				System.out.println("Validation Failed at Server Side");
			}
		
			
		}
		
		
	}

}
