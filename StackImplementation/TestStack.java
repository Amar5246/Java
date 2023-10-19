package p2;

import java.util.Scanner;
import Classes.*;
import Interfaces.Stack;

public class TestStack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int choice = 1;
        boolean flag = true; 
        boolean flag1=true;
        int count=0;
        Stack operation = null;
        while (choice != 0) {
            System.out.println("Choice 1: FixedStack");
            System.out.println("Choice 2: GrowableStack");
            System.out.println("Choice 3: pushElement");
            System.out.println("Choice 4: popElement"); 
            System.out.println("Choice 5: DisplayAll");
            
            System.out.println("Choice 0: Exit");
            System.out.println("Enter your choice ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (flag) {
                    	System.out.println("You have chosen Fixed Stack"); 
                    	operation = new FixedStack(); 
//                        System.out.println("value of case 1 operation"+operation);
                        flag = false;
                    } else {
                        System.out.println("You have already chosen the FixedStack. You cannot choose again.");
                    }
                    break;
                
                case 2:
                 System.out.println("You have chosen Growable Stack");
                    if (flag) {
                        operation = new GrowableStack();
                        flag = false; 
                        flag1=false;
                    } else {
                        System.out.println("You have already chosen the Growable Stack. You cannot choose again.");
                    }
                    break;
                
                case 3:
                 if (flag) {
                        System.out.println("You haven't chosen a stack");
                        break;
                    } 
                    if(count==Stack.STACK_SIZE&&flag1)
                    {
                    	System.out.println("Stack is full!!!"); 
                    	break;
                    }
                    count++;
                    System.out.println("Enter the name and address of the customer"); 
                    if (sc.hasNextLine()) {
                        sc.nextLine();
                    }
                    Object cust= new Customers(sc.nextLine(), sc.nextLine());
                    //System.out.println("value of case 1 operation"+operation);
                    operation.push(cust);
                    break;
                
                case 4: 
                	if(flag) {
                		System.out.println("You haven't chosen a stack");
                        break;
                	} 
                	operation.pop();   
                	break;
                	
                case 5:  
                	operation.DisplayAll();
                	break;
                	
            }
        }

		sc.close();
	}

}
