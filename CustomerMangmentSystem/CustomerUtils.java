package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Classes.CustMangment;
import Classes.ServicePlan;

public class CustomerUtils {
	public static Map<String,CustMangment> custInfo()
	{
		Map<String,CustMangment> mp=new HashMap<>();
		mp.put("amar.d.phadatare@gmail.com" ,new CustMangment("Amar","Phadatare","amar.d.phadatare@gmail.com","Amar4817",2000, LocalDate.parse("2002-01-24"),ServicePlan.GOLD)); 
		mp.put("adityashinde1234@gmail.com" ,new CustMangment("Aditay","Shinde","adityashinde1234@gmail.com","Adity4817",1000, LocalDate.parse("2000-04-17"),ServicePlan.SILVER)); 
		mp.put("saurabhshitole12@gmail.com" ,new CustMangment("Saurabh","Shitole","saurabhshitole12@gmail.com","Saurabh@4817",5000, LocalDate.parse("1999-10-12"),ServicePlan.DIAMOND)); 
		mp.put("shitoelyash78@gmail.com" ,new CustMangment("Yash","shitole","shitoelyash78@gmail.com","shitole1234",2000, LocalDate.parse("2002-01-24"),ServicePlan.GOLD)); 
		mp.put("phadatare4817@gmail.com" ,new CustMangment("Amar","Phadatare","phadatare4817@gmail.com","Amar4817",5000, LocalDate.parse("2002-01-24"),ServicePlan.DIAMOND)); 
		mp.put("yash307bhosale@gmail.com" ,new CustMangment("Yash","Bhosale","yash307bhosale@gmail.com","yash@307",10000, LocalDate.parse("2001-01-03"),ServicePlan.PLATINUM));  
		
		return mp;
	}
}
