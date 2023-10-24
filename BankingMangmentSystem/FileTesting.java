package p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import Classes.AccountType;
import Classes.BankingSystem;

public class FileTesting {

	public static void main(String[] args) {
		Map<Integer,BankingSystem> mp=new HashMap<>(); 
		//String name, String email, long adharNo, AccountType accountType, double balance,
		//LocalDate creationDate, LocalDate lastTransactionDate
		//mp.put(10001 ,new BankingSystem("Amar Phadatare","amar.d.phadatare@gmail.com",368347278,AccountType.SAVINGS,500,LocalDate.parse("2000-04-17"),LocalDate.parse("2022-11-17"))); 
		//mp.put(10002 ,new BankingSystem("Yash Shitole","yashShitole@gmail.com",368347279,AccountType.CURRENT,1000,LocalDate.parse("2009-04-17"),LocalDate.parse("2023-10-17"))); 
		//mp.put(10003 ,new BankingSystem("Saurabh Shitole","saurabhShitole@gmail.com",368347270,AccountType.DMAT,1500,LocalDate.parse("2018-02-24"),LocalDate.parse("2023-08-27"))); 
		//mp.put(10004 ,new BankingSystem("Yash Bhosale","yashbhosale@gmail.com",368347271,AccountType.SAVINGS,500,LocalDate.parse("2016-10-01"),LocalDate.parse("2022-01-17"))); 
		//mp.put(10005 ,new BankingSystem("Abhishek Jadhav","abhishekjadhav@gmail.com",368347272,AccountType.CURRENT,1000,LocalDate.parse("2019-04-28"),LocalDate.parse("2023-01-27"))); 
		//mp.put(10006 ,new BankingSystem("Niranjan Pawal","niranjanpawal@gmail.com",368347273,AccountType.DMAT,1500,LocalDate.parse("2009-09-07"),LocalDate.parse("2020-01-07")));  
		try(/*PrintWriter pw = new PrintWriter(new FileWriter("other.txt"));*/
			BufferedReader br=new BufferedReader(new FileReader("other.txt"))	
				)
		{
			mp.clear();
			Map<Integer,BankingSystem> mp1=new HashMap<>();
			//mp.values().stream().forEach(i->pw.println(i)); 
			br.lines().forEach(i->
			   {
				   String[] parts=i.split(","); 
				   //10001,Amar Phadatare,amar.d.phadatare@gmail.com,368347278,SAVINGS,500.0,2000-04-17,2022-11-17,true,false
				   mp1.put(Integer.parseInt(parts[0].trim()),
						   new BankingSystem(parts[1],parts[2],Long.parseLong(parts[3]),AccountType.valueOf(parts[4]),Double.parseDouble(parts[5])
								   ,LocalDate.parse(parts[6]),LocalDate.parse(parts[7]))); 
				  // mp1.get(Integer.parseInt(parts[0].trim()).setKycStatus(Boolean.parseBoolean(parts[8]));
			   }		
			); 
			//mp1.values().forEach(System.out::println); 
			mp1.forEach((k,v)->System.out.println(k +"-->"+v));
			mp.forEach((k,v)->System.out.println(k +"-->"+v));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
