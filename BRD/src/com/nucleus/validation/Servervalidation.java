package com.nucleus.validation;



import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nucleus.model.Customer;


	public class Servervalidation{
		
		public boolean validate(Customer custobj)
		{
			if(custcodeval(custobj.getCode()))
				{
					if(custnameval(custobj.getName()))
					{
						if(custadd1val(custobj.getAddress1()))
						{
							if(custadd2val(custobj.getAddress2()))
							{
								if(custpinval(custobj.getPincode()))
								{
									if(custemailval(custobj.getEmail()))
									{
										if(custcontval(custobj.getContact()))
										{
											if(custpcpval(custobj.getPcp()))
											{
												if(custflagval(custobj.getFlag()))
												{
													return true;	
												}
												else
												{
													System.out.println("Error in Status column");
													return false;
												}
											}	
											else
											{
												System.out.println("Error in Primary Contact Person column");
												return false;
											}
										}
										else
										{
											System.out.println("Error in  Customer Contact column");
											return false;
										}
									}
									else
									{
										System.out.println("Error in Customer Email column");
										return false;
									}
								}
								else
								{
									System.out.println("Error in Customer PinCode column");
									return false;
								}
							}
							else
							{
								System.out.println("Error in Customer Address2 column");
								return false;
							}
						}
						else
						{
							System.out.println("Error in Customer Address1 column");
							return false;
						}
					}
					else
					{
						System.out.println("Error in Customer Name column");
						return false;
					}
				}
				else
				{
					System.out.println("Error in Customer Code column");
					return false;
				}
		}
		ArrayList<String> a= new ArrayList<String>();
		public boolean custcodeval(String str0)
		{
		
			/*if(str0 != null && str0.length() > 0 && str0.length() <= 10){
				return true;
			}
			else{
				return false;
			}*/
			if( (str0.length()<=10) && !(str0.isEmpty()) )
			{
				
			if(a.size()==0)
				{
				a.add(str0);
				return true;
				}
			for(int i=0;i<a.size();i++)
			{
				if(a.get(i).contains(str0))
				{
					System.out.println("Duplicate customer id "+str0);
					return false;
				}
			}
			a.add(str0);
			return true;
			}
			else
			{
				return false;
			}
		}
		public boolean custnameval(String str1){
			
			String expression = "^[a-zA-Z0-9\\s]+";
			CharSequence inputstr1 = str1;
			Pattern p = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = p.matcher(inputstr1);
			
			if(matcher.matches() && str1 != null && str1 != null && str1.length() > 0 && str1.length() <= 30){
				return true;
			}
			else{
				return false;
			}
		}
		public boolean custadd1val(String str2){
			
			if(str2 != null && str2.length() > 0 && str2.length() <= 100){
				return true;
			}
			else{
				return false;
			}
		}
		public boolean custadd2val(String str3){
			
			if(str3.length() <= 100){
				return true;
			}
			else{
				return false;
			}
		}
		public boolean custpinval(String str4){
			
			//String expression = "^[0-9]";
			//CharSequence inputstr4 = str4;
			//Pattern p = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			//Matcher matcher = p.matcher(inputstr4);
			
			if(str4 != null && str4.length() == 6){
				return true;
			}
			else{
				return false;
			}
		}
		public boolean custemailval(String str5){
			
			String expression = "^(.+)@(.+)$";
			CharSequence inputstr5 = str5;
			Pattern p = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = p.matcher(inputstr5);
			
			if(matcher.matches() && str5 != null && str5.length() > 0 && str5.length() <= 100){
				return true;
			}
			else{
				return false;
			}
		}
		public boolean custcontval(String str6){
			
			if(str6.length() <= 20){
				return true;
			}
			else{
				return false;
			}
		}
		public boolean custpcpval(String str7){
			
			if(str7 != null && str7.length() > 0 && str7.length() <= 100)
			{
				return true;
			}
			else{
				return false;
			}
		}
		public boolean custflagval(String str8){
			
			if(str8 != null && str8.length() > 0 && str8.length() <= 1 && (str8.equals("A")||str8.equals("I"))){
				return true;
			}
			else{
				return false;
			}
		}
	}


