package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import Classes.BankingSystem;

public interface IoUtils {
	//creating method to stored the data in binary file 
	static void storedData(Map<Integer,BankingSystem> mp,String filename)throws FileNotFoundException,IOException
	{
		System.out.println("in Serlization");
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename)))
		{
			out.writeObject(mp);
		}
	} 
	@SuppressWarnings("unchecked")
	static Map<Integer,BankingSystem> restoredData(String filename)
	{
		System.out.println("in DeSerlization");
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(filename)))
		{
			return (Map<Integer,BankingSystem>)in.readObject();
		} 
		catch (Exception e) {
			return new HashMap<>();
		}
		
	} 
	
}
