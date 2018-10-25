package project.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "customerid")
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "adress")
	private String adress;
	@Column(name = "email")
	public String email;
	@OneToMany
	private List<Account> accountList;

	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", dob=" + dob + ", adress=" + adress + ", email=" + email
				+ ", accountList=" + accountList + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer() {

	}

	public Customer(String name, LocalDate dob, String adress, String email, Account account) {
		this.name = name;
		this.dob = dob;
		this.adress = adress;
		this.email = email;
		accountList = Arrays.asList(account);
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

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

}
