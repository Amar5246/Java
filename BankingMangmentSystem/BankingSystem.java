package Classes;

import java.time.LocalDate;
import java.util.Objects;

public class BankingSystem {
	
	private static int acc_no;
	private int accountNO;
	private String name;  
	private AccountType accountType; 
	private double balance;
	private LocalDate creationDate; 
	private LocalDate lastTransactionDate; 
	private boolean isActive; 
	static 
	{
		acc_no=10001;
	}
	public BankingSystem(String name, AccountType type, double balance, LocalDate creationDate,
			LocalDate lastTransactionDate) {
		super();
		this.name = name;
		this.accountType = type;
		this.balance = balance;
		this.creationDate = creationDate;
		this.lastTransactionDate = lastTransactionDate;
		this.isActive = true; 
		this.accountNO=acc_no++; 
	}
	
	public int getAccountNO() {
		return accountNO;
	}
	public void withdraw(double amount)
	{
		this.balance=balance-amount;
	} 
	public void depoite(double amount)
	{
		this.balance=balance+amount;
	}
	public void fundTransfer(BankingSystem obj,double amount)
	{
		obj.balance=obj.balance+amount; 
		this.balance=this.balance-amount;
	}
	public double getBalance() {
		return balance;
	}
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDate getLastTransactionDate() {
		return lastTransactionDate;
	}

	@Override
	public String toString() {
		return "BankingSystem [accountNO=" + accountNO + ", name=" + name + ", accountType=" + accountType
				+ ", balance=" + balance + ", creationDate=" + creationDate + ", lastTransactionDate="
				+ lastTransactionDate + ", isActive=" + isActive + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountNO);
	}
	//@Override
//	public boolean equals(Object obj) {
//		
//		BankingSystem other = (BankingSystem) obj;
//		return accountNO == other.accountNO;
//	}
	
	
	
	
	
	

}
