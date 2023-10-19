package p2;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Classes.BankingSystem;
import utils.BankingUtils;
import utils.BankingValidationrules;

public class BankingSystemMangment {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Map<Integer,BankingSystem> mp=BankingUtils.custInfo(); 
		boolean exit=true; 
		int choice; 
		Set<Integer> set=mp.keySet(); 
		Collection<BankingSystem> coll=mp.values();
		while(exit)
		{
			try
			{
				System.out.println("Case 1: Add account");
				System.out.println("Case 2: Withdraw");
				System.out.println("Case 3: Deposite");
				System.out.println("Case 4: Fund transfer");
				System.out.println("Case 5: Disable accounts with no transactions in 1 year"); 
				System.out.println("case 6: Display all "); 
				System.out.println("case 7: Display all accounts active status ");
				System.out.println("Case 0: Exit");
				System.out.println("Enter your choice"); 
				choice=sc.nextInt();  
				switch(choice)
				{
				case 1: 
					System.out.println("Adding account"); 
					System.out.println("Enter information of customers fields are following ");  
					System.out.println("Name,Account type,balance,todays date,last transaction date");
					BankingSystem customer=BankingValidationrules.validateAll(sc.next(),sc.next().toUpperCase(),sc.nextDouble(),LocalDate.parse(sc.next()),LocalDate.parse(sc.next()));
					int accountno=customer.getAccountNO(); 
					mp.put(accountno, customer);  
					System.out.println("Account added !!"); 
					break;
				case 2: 
					System.out.println("Enter your account no to withdraw money ");  
					int no=sc.nextInt();
					BankingValidationrules.validateAccountNo(no,set); 
					System.out.println("Enter amount to withdraw"); 
					double amount=sc.nextDouble(); 
					customer=mp.get(no); 
					BankingValidationrules.validateBalance(amount,customer); 
					customer.withdraw(amount); 
					System.out.println("Current balance is");
					System.out.println(customer.getBalance());
					break;
				case 3: 
					System.out.println("Enter your account no to deposit money"); 
					no=sc.nextInt(); 
					BankingValidationrules.validateAccountNo(no,set); 
					customer=mp.get(no);
					System.out.println("Enter amount to withdraw"); 
					amount=sc.nextDouble(); 
					customer.depoite(amount);
					System.out.println("Current balance is");
					System.out.println(customer.getBalance()); 
					break;
				case 4: 
					System.out.println("Enter account no from which you want to transfer money");
					no=sc.nextInt();
					BankingValidationrules.validateAccountNo(no,set);
					System.out.println("Enter account no to which you want to transfer money");
					int no1=sc.nextInt(); 
					BankingValidationrules.validateAccountNo(no1,set); 
					customer=mp.get(no); 
					BankingSystem customer1=mp.get(no1);  
					System.out.println("Enter amount to transfer");
					amount=sc.nextDouble(); 
					customer.fundTransfer(customer1, amount); 
					System.out.println("Current balance is");
					System.out.println(customer.getBalance()); 
					break;
				case 5: 
					for(BankingSystem b:coll)
					{
						if(Period.between(b.getLastTransactionDate(),LocalDate.now()).toTotalMonths()>=12)
						{
							b.setActive(false);
						}
					} 
					System.out.println("All disabled accounts are");
					for(BankingSystem b:coll)
					{
						if(!(b.isActive()))
						{
							System.out.println(b);
						}
					}
					break; 
				case 6: 
					for(BankingSystem b:coll)
					{
						System.out.println(b);
					}
					break; 
				case 7: 
					for(BankingSystem b:coll)
					{
						System.out.println(b.getAccountNO()+" "+b.isActive());
					}
				}
				
			}
			catch(Exception e)
			{
				if(sc.hasNextLine())
				{
					sc.nextLine(); 
					System.out.println("incorrect input !!");
				} 
				System.out.println(e.getMessage()); 
				e.printStackTrace();
			}
		}		
		sc.close();
	}

}
