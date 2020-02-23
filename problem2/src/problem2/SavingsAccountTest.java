package problem2;

public class SavingsAccountTest {
	
	public static void main(String[] args) {
		//declare new savings accounts for saver 1 and 2
		SavingsAccount saver1 = new SavingsAccount ();
		SavingsAccount saver2 = new SavingsAccount ();
		
		//set balances for each savings account
		saver1.setSavingsBalance(2000.00);
		saver2.setSavingsBalance(3000.00);
		
		//set the interest rate to %4
		SavingsAccount.setAnnualInterestRate(0.04);
		
		//print out monthly balances for saver 1
		for(int i=0;i<12;i++) {
			saver1.setSavingsBalance(saver1.getSavingsBalance() + saver1.calculateMonthlyInterets(saver1.getSavingsBalance()));
			System.out.printf("Balance for month %d for saver1 $",i+1);
			System.out.printf("%.2f",saver1.getSavingsBalance());
			System.out.println("");
			}
		
		//print out monthly balances for saver 2
		for(int i=0;i<12;i++) {
			saver2.setSavingsBalance(saver2.getSavingsBalance() + saver2.calculateMonthlyInterets(saver2.getSavingsBalance()));
			System.out.printf("Balance for month %d for saver2 $",i+1);
			System.out.printf("%.2f",saver2.getSavingsBalance());
			System.out.println("");
			}
		
		//change interest rate to %5
		SavingsAccount.setAnnualInterestRate(0.05);
		
		//print out balances for the next month after change to %5
		
		//saver1
		saver1.setSavingsBalance(saver1.getSavingsBalance() + saver1.calculateMonthlyInterets(saver1.getSavingsBalance()));
		System.out.printf("Balance for saver1 $");
		System.out.printf("%.2f",saver1.getSavingsBalance());
		System.out.println("");
		
		//saver2
		saver2.setSavingsBalance(saver2.getSavingsBalance() + saver2.calculateMonthlyInterets(saver2.getSavingsBalance()));
		System.out.printf("Balance for saver2 $");
		System.out.printf("%.2f",saver2.getSavingsBalance());
		System.out.println("");
		
	}

}
