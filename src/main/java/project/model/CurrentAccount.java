package project.model;

public final class CurrentAccount extends Account {


	double min_balance = 1000;
	public   void deposit(double amount)
	{
		super.deposit(amount); 
	}
	
	public   void withdraw(double amount)
	{
		super.withdraw(amount);
	}
	
}


