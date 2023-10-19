package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Set;

import Classes.*;
import custom_exceptions.CustomerHandelingException;


public class CustomerValidationRules { 
	public static void duplicateCustomers(String email,Set<String> list)throws CustomerHandelingException
	{
		 
		if(list.contains(email))
		{
			throw new CustomerHandelingException("Alerady register with the provided email");
		} 
		System.out.println("no duplicates");
	} 
	public static ServicePlan validatePlan(String plan)throws IllegalArgumentException
	{
		return ServicePlan.valueOf(plan);
	} 
	public static double validateRegestrationAmount(double reg_Amount,String plan)throws CustomerHandelingException
	{
		ServicePlan plan1=ServicePlan.valueOf(plan);
		if(!(plan1.getReg_Amount()==reg_Amount))
		{
			throw new CustomerHandelingException("regestration amount is invalide");
		} 
		return plan1.getReg_Amount();
	}  
	public static LocalDate validateDate(String date)throws DateTimeParseException
	{
		LocalDate Date=LocalDate.parse(date); 
		return Date;
	}
	
	public static CustMangment validateAll(String first_name, String last_name, String email, String password, double reg_amount,
			String dob, String plan,Set<String> list) throws CustomerHandelingException,IllegalArgumentException,DateTimeParseException
	{
		duplicateCustomers(email,list); 
		ServicePlan plan2=validatePlan(plan); 
		double amount=validateRegestrationAmount(reg_amount,plan); 
		LocalDate Date=validateDate(dob);
		return new CustMangment(first_name,last_name,email,password,amount,Date,plan2);
	} 
	public static void findEmailOfCustomer(String email,Set<String> list) throws CustomerHandelingException
	{
		  
		if(!(list.contains(email)))
		{
			throw new CustomerHandelingException("Email address not found plz try again !!!");
		}
	}
	
	public static void cheackPassword(CustMangment customer,String pass) throws CustomerHandelingException
	{ 
		 
		String pass1=customer.getPassword();
		if(!(pass1.equals(pass)))
		{
			throw new CustomerHandelingException("incorrect pasword");
		} 
		System.out.println("Welcome \n loged in succefully!!!!!");
	}
	
}
