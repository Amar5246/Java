package Classes;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankingSystem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int acc_no;
	private int accountNO;
	private String name;  
	private String Email; 
	private long adharNo;
	private AccountType accountType; 
	private double balance;
	private LocalDate creationDate; 
	private LocalDate lastTransactionDate; 
	private boolean isActive; 
	private boolean kycStatus; 
	private List<TransactionDetails> transDetails=new ArrayList<>();
	static 
	{
		acc_no=10001;
	}
	//the following constructor is only for testing and adding the data cause i can not test the functionalities if the current date and  
	//last transaction date is same 
	public BankingSystem(String name, String email, long adharNo, AccountType accountType, double balance,
			LocalDate creationDate, LocalDate lastTransactionDate) {
		super();
		this.name = name;
		Email = email;
		this.adharNo = adharNo;
		this.accountType = accountType;
		this.balance = balance;
		this.creationDate = creationDate;
		this.lastTransactionDate = lastTransactionDate; 
		this.accountNO=acc_no++;   
		this.isActive=true; 
		this.kycStatus=false;
	}

	public BankingSystem(String name, String email, long adharNo, AccountType accountType, double balance) {
		super();
		this.name = name;
		this.Email = email;
		this.adharNo = adharNo;
		this.accountType = accountType;
		this.balance = balance;
		this.creationDate = LocalDate.now();
		this.lastTransactionDate = LocalDate.now(); 
		this.accountNO=acc_no++; 
		this.isActive=true; 
		this.kycStatus=false;
	}

	public boolean isKycStatus() {
		return kycStatus;
	}

	public void setKycStatus(boolean kycStatus) {
		this.kycStatus = kycStatus;
	}

	public int getAccountNO() {
		return accountNO;
	}
	public void withdraw(double amount)
	{
		this.balance=balance-amount;  
		System.out.println("Enter in withdraw");
		TransactionDetails transaction =new TransactionDetails(LocalDateTime.now(),this.name, TranscationType.WITHDRAW,this.accountNO,amount); 
		System.out.println("transaction !!!"); 
		System.out.println(transaction);
		this.transDetails.add(transaction);
	} 
	public void depoite(double amount)
	{
		this.balance=balance+amount;
		TransactionDetails transaction =new TransactionDetails(LocalDateTime.now(),this.name, TranscationType.DEPOSITE,this.accountNO,amount); 
		this.transDetails.add(transaction);
	}
	public void fundTransfer(BankingSystem obj,double amount)
	{
		this.withdraw(amount); 
		obj.depoite(amount);  
		//LocalDateTime transDateTime, String accHolderName, TranscationType type, int accNO,
		//double amount, String otherName, int otherAccNo
		TransactionDetails transaction =new TransactionDetails(LocalDateTime.now(),this.name, TranscationType.FUND_TRANSFER,this.accountNO,amount,
				obj.name,obj.accountNO); 
		this.transDetails.add(transaction);  
		transaction =new TransactionDetails(LocalDateTime.now(),obj.name, TranscationType.FUND_RECIVED,obj.accountNO,amount,
			this.name,this.accountNO);
		obj.transDetails.add(transaction);
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
	public String getName() {
		return name;
	}

	public String getEmail() {
		return Email;
	}

	public long getAdharNo() {
		return adharNo;
	} 
	
	public List<TransactionDetails> getTransDetails() {
		return transDetails;
	}
	public static void setAcc_no(int acc_no) {
		BankingSystem.acc_no = acc_no;
	}
	@Override
	public String toString() {
		return "BankingSystem [accountNO=" + accountNO + ", name=" + name + ", Email=" + Email + ", adharNo=" + adharNo
				+ ", accountType=" + accountType + ", balance=" + balance + ", creationDate=" + creationDate
				+ ", lastTransactionDate=" + lastTransactionDate + ", isActive=" + isActive + "]";
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
