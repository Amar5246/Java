package p2;
import java.time.LocalDate;
import java.util.*;


import Classes.*;
import custom_exceptions.CustomerHandelingException;

import static utils.CustomerValidationRules.*; 
import utils.*;

public class CustomerMangement {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); 
		Map<String,CustMangment> mp=CustomerUtils.custInfo();
		Set<String> list=mp.keySet(); 
		Collection<CustMangment> val=mp.values(); 
		List<CustMangment> val1=new ArrayList<>(val);
		boolean exit=false; 
		while(!exit)
		{
			System.out.println("Choice 1: Sign Up");
		 	System.out.println("Choice 2: Sign in");
			System.out.println("Choice 3: Change Password");
			System.out.println("Choice 4: Un subscribe customer");
			System.out.println("Choice 5: Display all"); 
			System.out.println("Choice 6: Sort according email(primary key)"); 	 
			System.out.println("Choice 7: Sort according Firstname "); 
			System.out.println("Choice 8: Un subscribe customer according DOB"); 
			System.out.println("Choice 0: exit"); 
			System.out.println();
			System.out.println("Enter your choice"); 
			try
			{
				switch(sc.nextInt())
				{
				case 1: 
					System.out.println("Enter customer details respectively:");
					System.out.println("first_name,last_name,email,password,reg_amount,dob(yyy-mm-dd),plan");   
					String email=sc.next();
					CustMangment customer=validateAll(sc.next(), sc.next(),email , sc.next(), sc.nextDouble(),
							sc.next(),sc.next(),list); 
					mp.put(email,customer); 
					System.out.println("customer added succfully"); 
					break; 
				case 2: 
					System.out.println("Enter your email id");  
					String mail=sc.next();
					findEmailOfCustomer(mail,list);  
					CustMangment customers1=mp.get(mail);
					System.out.println("Enter your password");
					String pass=sc.next();
					cheackPassword(customers1,pass);
					break; 
				case 3: 
					 System.out.println("Enter email id associated with your account to change password"); 
					 String s= sc.next();
					 if(!(list.contains(s)))
					 {
						 throw new CustomerHandelingException("customer not found");
					 }
					 customer=mp.get(s); 
					 System.out.println("Enter a new password");
					 customer.setPassword(sc.next()); 
					 System.out.println("Password changed successfully");
					 break;
				case 4:
					System.out.println("Enter the email id of the customer you want to un-subscribe");
					 s= sc.next(); 
					mp.remove(s); 
					break;
				case 5: 
					System.out.println("Details of all customers are"); 
					
					for(String a: list)
					{
						System.out.println(mp.get(a));
					} 
					break; 
				case 6: 
					TreeMap<String,CustMangment> sortedMap=new TreeMap<String, CustMangment>(mp); 
					for(CustMangment q:sortedMap.values())
					{
						System.out.println(q);
					}
					break;
				case 7: 
					Collections.sort(val1,new CustomerFirstNameComprator());  
					Map<String,CustMangment> sortedMap1=new LinkedHashMap<>();
					for(CustMangment w:val1)
					{
						String n=w.getEmail(); 
						sortedMap1.put(n,w);
					} 
					for(CustMangment q:sortedMap1.values())
					{
						System.out.println(q);
					}
					break; 
				case 8: 
					System.out.println("Enter a dob of a customer you want to un subscribe ");
					LocalDate date=LocalDate.parse("2002-01-24"); 
					Iterator<String> itr = list.iterator();  
					String[] arr=new String[10]; 
					int i=0;
					while(itr.hasNext())
					{
						s=itr.next();  
						if(mp.get(s).getDob().equals(date))
						{  
							arr[i++]=s;
							System.out.println("Removed customer succesfully ");
						}
					} 
					for(int j=0;j<10;j++)
					{
						if(arr[j]==null)
						{
							continue;
						}  
						else
						{
							mp.remove(arr[j]);
						}
					}
					break; 
				case 0: 
					exit=true; 
					break;
				}
			}
			catch(Exception e)
			{
				if(sc.hasNextLine())
				{
					sc.nextLine();
					System.out.println("you have enter the wrong input plz cheack again");
				}
				e.printStackTrace();
				System.out.println("exit");
			}
		}
		sc.close();
	}

}
