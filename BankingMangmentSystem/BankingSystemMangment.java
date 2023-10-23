package p2;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;

import Classes.BankingSystem;
import custom_exceptions.BankingHandlingException;
import utils.BankingUtils;
import utils.BankingValidationrules;
import utils.IoUtils;

public class BankingSystemMangment {

	public static void main(String[] args) {
		String filename="accountDetails.sre"; 
		//in case you want already populated data use BankingUtils class method 
		Map<Integer,BankingSystem> mp=IoUtils.restoredData(filename);  // DeSerialization  
		int size =mp.size();
		BankingSystem.setAcc_no(10001+size);
		//mp=BankingUtils.custInfo();
		boolean exit=true; 
		int choice; 
		Set<Integer> set=mp.keySet(); 
		Collection<BankingSystem> coll=mp.values();
		mp.get(10001).setKycStatus(true);
		mp.get(10003).setKycStatus(true);
		mp.get(10004).setKycStatus(true); 
		try(Scanner sc=new Scanner(System.in);)
		{
		while(exit)
		{
			try
			{
				System.out.println("Case 1: Add account"); 
				System.out.println("Csse 2: KYC");
				System.out.println("Case 3: Withdraw");
				System.out.println("Case 4: Deposite");
				System.out.println("Case 5: Fund transfer");
				System.out.println("Case 6: Disable accounts with no transactions in 1 year"); 
				System.out.println("case 7: Display all "); 
				System.out.println("case 8: Display all accounts active status "); 
				System.out.println("Case 1: transaction details");
				System.out.println("Case 0: Save and Exit");
				System.out.println("Enter your choice"); 
				choice=sc.nextInt();  
				switch(choice)
				{
				case 1: //creating account
					System.out.println("Adding account"); 
					System.out.println("Enter information of customers fields are following ");  
					System.out.println("Name,email,adhar no,Account type(savings,current,dmat),balance");
					BankingSystem customer=BankingValidationrules.validateAll(sc.next(),sc.next(),sc.nextLong(),sc.next().toUpperCase(),sc.nextDouble());
					int accountno=customer.getAccountNO(); 
					mp.put(accountno, customer);  
					System.out.println("Account added !!"); 
					break; 
				case 2://KYC validations
					System.out.println("Give your details : 1 accno 2 name 3 Email 4 adharNO"); 
					int acno=sc.nextInt();
					BankingValidationrules.validateAccountNo(acno,set);
					//int accno,String Name,String Email,long adharNo,Map<Integer,BankingSystem> mp
					BankingValidationrules.kycValidation(sc.nextInt(),sc.next(),sc.next(),sc.nextLong(),mp);   
					mp.get(acno).setKycStatus(true);
					System.out.println("KYC regestration successfull ");
				case 3: //withdraw functionality
					System.out.println("Enter your account no to withdraw money ");  
					int no=sc.nextInt();
					BankingValidationrules.validateAccountNo(no,set); 
					if(!(mp.get(no).isKycStatus()))
					{
						throw new BankingHandlingException("Haven't done KYC can't withdraw money");
					}
					System.out.println("Enter amount to withdraw"); 
					double amount=sc.nextDouble(); 
					customer=mp.get(no); 
					BankingValidationrules.validateBalance(amount,customer); 
					customer.withdraw(amount); 
					System.out.println("Current balance is");
					System.out.println(customer.getBalance());
					break;
				case 4: //Deposit functionality
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
				case 5: //fund transfer functionality
					System.out.println("Enter account no from which you want to transfer money");
					no=sc.nextInt();
					BankingValidationrules.validateAccountNo(no,set); 
					if(!(mp.get(no).isKycStatus()))
					{
						throw new BankingHandlingException("Haven't done KYC can't withdraw money");
					}
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
				case 6: //deactivating accounts with no transaction in last one year
//					for(BankingSystem b:coll)
//					{
//						if(Period.between(b.getLastTransactionDate(),LocalDate.now()).toTotalMonths()>=12)
//						{
//							b.setActive(false);
//						}
//					} 
					//using lambda expression 
					Consumer<BankingSystem> action=b -> {
					    if (Period.between(b.getLastTransactionDate(), LocalDate.now()).toTotalMonths() >= 12) {
					        b.setActive(false);
					    }
					};
					coll.forEach(action);
					System.out.println("All disabled accounts are");
//					for(BankingSystem b:coll)
//					{
//						if(!(b.isActive()))
//						{
//							System.out.println(b);
//						}
//					} 
					coll.forEach(c->{if(!(c.isActive())){System.out.println(c);}});
					break; 
				case 7: //display all
//					for(BankingSystem b:coll)
//					{
//						System.out.println(b);
//					} 
					coll.forEach(c->System.out.println(c));
					break; 
				case 8: //accounts activity status
//					for(BankingSystem b:coll)
//					{
//						System.out.println(b.getAccountNO()+" "+b.isActive());
//					}
					coll.forEach(c->System.out.println(c.getAccountNO()+" "+c.isActive()));  
					break; 
				case 9: //transaction details
					System.out.println("Enter your accno"); 
					no=sc.nextInt(); 
					mp.get(no).getTransDetails().stream().forEach(c->System.out.println(c));
				case 0: //Save and exit
					exit=false; 
					//Serialization 
					IoUtils.storedData(mp,filename);
					break;
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
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
