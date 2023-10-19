package Classes;

import Interfaces.Stack;

public class FixedStack implements Stack {

	public static int count=0; 
	public static Customers[]customers=new Customers[STACK_SIZE];
	
	@Override
	public void push(Object obj) {
		customers[count++]=(Customers)obj;
	}

	@Override
	public void pop() {
		
		if(customers[count]==null) { System.out.println("empty stack"); }
		else {
		System.out.println(customers[--count].toString());
		customers[count]=null; 
		}
	} 
	public void DisplayAll()
	{
	    for(Customers s : customers)
	    {
	    	if(s!=null)
	    	System.out.println(s);
	    }
	}

}
