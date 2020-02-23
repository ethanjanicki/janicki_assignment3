package problem2;



public class SavingsAccount{
	private static double annualInterestRate;
	
	private double savingsBalance;
	
	public static double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public static void setAnnualInterestRate(double annualInterestRate) {
		SavingsAccount.annualInterestRate = annualInterestRate;
	}
	
	
	
	public  double getSavingsBalance() {
		return savingsBalance;
	}
	public  void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	public static double calculateMonthlyInterets(double savingsBalance) {
		double temp;
		temp = savingsBalance * annualInterestRate;
		temp = temp/12.0;
		return temp;
		
		
		
	}
	public static void modifyInterestRate(double newInterestRate) {
		annualInterestRate = newInterestRate;
	}

	
	
}
 
