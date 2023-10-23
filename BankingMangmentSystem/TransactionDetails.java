package Classes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionDetails { 
	private static long no; 
	private long transNo; 
	private LocalDateTime transDateTime; 
	private String accHolderName; 
	private TranscationType type; 
	private int accNO; 
	private double amount; 
	private String otherName; 
	private int otherAccNo; 
	
	static
	{
		no=329572290;
	}
	
	public TransactionDetails( LocalDateTime transDateTime, String accHolderName, TranscationType type,
			int accNO,double amount) {
		super();
		this.transNo = no++;
		this.transDateTime = transDateTime;
		this.accHolderName = accHolderName;
		this.type = type;
		this.accNO = accNO; 
		this.amount=amount;
	} 
	

	public TransactionDetails(LocalDateTime transDateTime, String accHolderName, TranscationType type, int accNO,
			double amount, String otherName, int otherAccNo) {
		super(); 
		this.transNo=no;
		this.transDateTime = transDateTime;
		this.accHolderName = accHolderName;
		this.type = type;
		this.accNO = accNO;
		this.amount = amount;
		this.otherName = otherName;
		this.otherAccNo = otherAccNo;
	}


	@Override
	public String toString() {
		if(this.type==TranscationType.FUND_RECIVED||this.type==TranscationType.FUND_TRANSFER) {
		return "TransactionDetails [transNo=" + transNo + ", transDateTime=" + transDateTime + ", accHolderName="
				+ accHolderName + ", type=" + type + ", accNO=" + accNO + "amount" + amount + "otherBankersName" 
				+ otherName + "otherBankersAccNo" + otherAccNo + "]";
		} 
		return  "TransactionDetails [transNo=" + transNo + ", transDateTime=" + transDateTime + ", accHolderName="
		        + accHolderName + ", type=" + type + ", accNO=" + accNO + "Amount" + amount + "]";
	}  
	
	
	
}
