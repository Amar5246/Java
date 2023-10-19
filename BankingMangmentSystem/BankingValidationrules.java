package utils;



import java.time.LocalDate;
import java.util.Set;

import Classes.AccountType;
import Classes.BankingSystem;
import custom_exceptions.BankingHandlingException;

public class BankingValidationrules {
	public static AccountType validateAccountTypeAndBalance(String type,double balance ) throws IllegalArgumentException,BankingHandlingException
	{
		AccountType accountType=AccountType.valueOf(type); 
		if(accountType.getintialBalance()<balance)
		{
			throw new BankingHandlingException("Amount required to create account is not sufficient!!");
		}
		return AccountType.valueOf(type);
	} 
	public static void validateBalance(double amount,BankingSystem cust) throws BankingHandlingException
	{
		if(cust.getBalance()<amount)
		{
			throw new BankingHandlingException("Insufficient balance!!!");
		} 
		
	}   
	public static void validateAccountNo(int accno,Set<Integer> set)throws BankingHandlingException
	{
		if(!(set.contains(accno)))
		{
			throw new BankingHandlingException("account does not exist!!");
		}
	}
	public static BankingSystem validateAll(String name, String type, double balance, LocalDate creationDate,
			LocalDate lastTransactionDate)throws BankingHandlingException,IllegalArgumentException
	{
		AccountType accountType=validateAccountTypeAndBalance(type,balance);  
		return new BankingSystem(name,accountType,balance,creationDate,
			lastTransactionDate);
	}
	
}
