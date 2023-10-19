package Classes;

import java.time.LocalDate;
import java.util.Objects;



public class CustMangment implements Comparable<CustMangment> {
	
	private static int cust_id,i;
	private String first_name; 
	private String last_name; 
	private String email; 
	private String password; 
	private double reg_amount; 
	private LocalDate dob; 
	private ServicePlan plan;
	private int customer_id; 
	
	static {
		cust_id=0; 
		i=0;
	}

	public CustMangment(String first_name, String last_name, String email, String password, double reg_amount,
			LocalDate dob, ServicePlan plan) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.reg_amount = reg_amount;
		this.dob = dob;
		this.plan = plan;  
		this.customer_id=cust_id++;
	}
	public String getFirst_name() {
		return first_name;
	}
	public CustMangment(String email) {
		super();
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password; 
	}
	public String getEmail() {
		return email;
	}	
	public LocalDate getDob() {
		return dob;
	}
	@Override
	public String toString() {
		return "Custinfo"+(i++)+"[first_anme=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", reg_amount=" + reg_amount + ", dob=" + dob + ", plan=" + plan + ", customer_id=" + customer_id
				+ "]";
	}
	@Override
	public boolean equals(Object obj) { 
		if(obj instanceof CustMangment)
		{
			CustMangment other = (CustMangment) obj;
			return Objects.equals(email, other.email);
		} 
		return false;
		
	}
	@Override
	public int compareTo(CustMangment other) {
		
		return this.email.compareTo(other.email);
	}  
	
	
	
}
