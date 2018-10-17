package project.model;

public abstract class Account {
	long Account_Number;
	String name;
	double balance=0;
	
	public void deposit(double amount)
	{
		System.out.println("Amount Deposited "+amount);
		balance += amount; 
	}
	
	public void withdraw(double amount)
	{
		System.out.println("Amount withdrawn.. "+amount);
		balance -= amount;
	}
	
	public void displayAccountDetails()
	{
		System.out.println("Displaying account details...");
		System.out.println("Account no " + Account_Number );
		System.out.println("Name " + name );
	}
	
	public void displayBalance()
	{
		System.out.println("Balance is "+balance);
	}
	
}

