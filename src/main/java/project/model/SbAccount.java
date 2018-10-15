package project.model;

public final class SbAccount extends Account {
	double min_balance = 5000;
	void addInterest(int months)
	{
		balance = balance + (months * 0.04);
	}
	
	public   void deposit(double amount)
	{
		super.deposit(amount);
	}
	
	public   void withdraw(double amount)
	{
		super.withdraw(amount);
	}

}
