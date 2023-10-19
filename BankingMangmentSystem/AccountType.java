package Classes;

public enum AccountType {
	SAVINGS(500),CURRENT(1000),DMAT(1500);
	
	double intialBalance;

	private AccountType(double intialBalance) {
		this.intialBalance = intialBalance;
	}

	public double getintialBalance() {
		return intialBalance;
	}

	public void setintialBalance(double intialBalance) {
		this.intialBalance = intialBalance;
	} 
	
	public String toString()
	{
		return name();
	}
	
}
