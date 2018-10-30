package project.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_transactions")
public class Transaction {
	@Id
    @Column(name = "transid")
    @GeneratedValue(strategy = IDENTITY)
	private Integer transid;
	@Column(name = "transdate")
	private Date transdate;
	@Column(name = "description")
	private String description;
	@Column(name = "chequeNumber")
	private Integer chequeNumber;
	@Column(name = "withdraw")
	private Integer withdraw;
	@Column(name = "deposit")
	private Integer deposit;
	@Column(name = "availableBalance")
	private Double availableBalance;

	

	public Transaction(Date transdate, String description, Integer withdraw,
			Integer deposit, Double availableBalance) {
		this.transdate = transdate;
		this.description = description;
		this.withdraw = withdraw;
		this.deposit = deposit;
		this.availableBalance = availableBalance;
	}
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public Integer getTransid() {
		return transid;
	}

	public void setTransid(Integer transid) {
		this.transid = transid;
	}

	public Date getTransdate() {
		return transdate;
	}

	public void setTransdate(Date transdate) {
		this.transdate = transdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(Integer chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	public Integer getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Integer withdraw) {
		this.withdraw = withdraw;
	}

	public Integer getDeposit() {
		return deposit;
	}

	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}

	public Double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}
	@Override
	public String toString() {
		return "Transaction [transid=" + transid + ", transdate=" + transdate + ", description=" + description
				+ ", chequeNumber=" + chequeNumber + ", withdraw=" + withdraw + ", deposit=" + deposit
				+ ", availableBalance=" + availableBalance + "]";
	}



}
