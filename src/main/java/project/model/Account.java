package project.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "account_details")
public class Account {
    @Id
    @Column(name = "accountid")
    @GeneratedValue(strategy = IDENTITY)
    private long accountNumber;
    @Column(name = "name")
    private String name;
    @Column(name = "dob")
    private LocalDate dob;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "type")
    private String type;

    @Column(name = "balance")
    private double balance;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountid")
	private List<Transaction> transactionList;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cardnumber")
    private CreditCard creditCard;

    public Account() {
        
    }

    public Account(String name, LocalDate dob, String address, String email, String type) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.type = type;
        this.balance = 0;
    }

    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", name=" + name + ", dob=" + dob + ", address=" + address
                + ", email=" + email + ", type=" + type + ", balance=" + balance + "]";
    }


    public Account(String type) {
        this.name = type;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long account_Number) {
        accountNumber = account_Number;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

	public void addToAmount(double amount){
        balance += amount;
    }

    public void subtractToAmount(double amount){
        balance -= amount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}

