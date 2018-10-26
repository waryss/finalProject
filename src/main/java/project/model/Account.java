package project.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_details")
public  class Account {
	@Id
    @Column(name = "accountid")
    @GeneratedValue(strategy = IDENTITY)
	private long Account_Number;
	@Column(name = "name")
	String name;
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "adress")
	private String adress;
	@Column(name = "email")
	private String email;
	@Column(name = "type")
	private String type;
	
	@Column(name = "balance")
	private double balance;
	
	public Account( String name, LocalDate dob, String adress, String email, String type) {
		this.name = name;
		this.dob = dob;
		this.adress = adress;
		this.email = email;
		this.type = type;
		this.balance = 0;
	}

	@Override
	public String toString() {
		return "Account [Account_Number=" + Account_Number + ", name=" + name + ", dob=" + dob + ", adress=" + adress
				+ ", email=" + email + ", type=" + type + ", balance=" + balance + "]";
	}



	public Account(String type) {
		this.name = type;
	}

	public long getAccount_Number() {
		return Account_Number;
	}

	public void setAccount_Number(long account_Number) {
		Account_Number = account_Number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
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

