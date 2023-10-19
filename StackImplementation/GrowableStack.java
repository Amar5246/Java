package Classes;

import Interfaces.Stack;

public class GrowableStack implements Stack {

	
	public static int count=0; 
	public static Customers[]customers=new Customers[STACK_SIZE];
	@Override
	public void push(Object obj) {
		int size=STACK_SIZE;
		if(count==size)
		{
			
			Customers[]b=new Customers[size*2];  
			size*=2;
			for(int i=0;i<customers.length;i++)
			{
				b[i]=customers[i];
			} 
			customers=b;
		} 
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
	    	System.out.println(s);
	    }
	}

}
