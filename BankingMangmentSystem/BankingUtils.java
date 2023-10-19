package utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import Classes.AccountType;
import Classes.BankingSystem;


public class BankingUtils {
	public static Map<Integer,BankingSystem> custInfo()
	{
		Map<Integer,BankingSystem> mp=new HashMap<>();
		mp.put(1001 ,new BankingSystem("Amar Phadatare",AccountType.SAVINGS,500,LocalDate.parse("2000-04-17"),LocalDate.parse("2022-11-17"))); 
		mp.put(1002 ,new BankingSystem("Yash Shitole",AccountType.CURRENT,1000,LocalDate.parse("2009-04-17"),LocalDate.parse("2023-10-17"))); 
		mp.put(1003 ,new BankingSystem("Saurabh Shitole",AccountType.DMAT,1500,LocalDate.parse("2018-02-24"),LocalDate.parse("2023-08-27"))); 
		mp.put(1004 ,new BankingSystem("Yash Bhosale",AccountType.SAVINGS,500,LocalDate.parse("2016-10-01"),LocalDate.parse("2022-01-17"))); 
		mp.put(1005 ,new BankingSystem("Abhishek Jadhav",AccountType.CURRENT,1000,LocalDate.parse("2019-04-28"),LocalDate.parse("2023-01-27"))); 
		mp.put(1006 ,new BankingSystem("Niranjan Pawal",AccountType.DMAT,1500,LocalDate.parse("2009-09-07"),LocalDate.parse("2020-01-07")));  
		
		return mp;
	}
}
