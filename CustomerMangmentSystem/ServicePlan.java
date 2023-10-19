package Classes;

public enum ServicePlan {
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000); 
	private double reg_Amount=0;
	private ServicePlan(int reg_Amount)
	{
		this.reg_Amount=reg_Amount; 
	}
	public double getReg_Amount() {
		return reg_Amount;
	}
//	public void setReg_Amount(int reg_Amount) {
//		this.reg_Amount = reg_Amount;
//	} 
	public String toString()
	{
		return name()+"REgestration amount is :" +reg_Amount;
	}
//	public void setReg_Amount(int reg_Amount) {
//		this.reg_Amount = reg_Amount;
//	} 
	
}
