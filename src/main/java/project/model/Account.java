package project.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public  class Account {
	@Id
    @Column(name = "accountid")
    @GeneratedValue(strategy = IDENTITY)
	long Account_Number;
	@Column(name = "type")
	String name;
	@Column(name = "balance")
	double balance;
	
	
	@Override
	public String toString() {
		return "Account [Account_Number=" + Account_Number + ", name=" + name + ", balance=" + balance + "]";
	}

	public Account(String type) {
		this.name = type;
	}

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

