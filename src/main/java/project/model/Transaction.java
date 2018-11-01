package project.model;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "account_transactions")
public class Transaction {
    @Id
    @Column(name = "transid")
    @GeneratedValue(strategy = IDENTITY)
    private Integer transid;
    @Column(name = "transdate")
    private LocalDate transdate;
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


    @Column(name = "accountid")
    private Long accountId;


    public Transaction(LocalDate transdate, String description, Integer withdraw,
                       Integer deposit, Double availableBalance, Long accountId) {
        this.transdate = transdate;
        this.description = description;
        this.withdraw = withdraw;
        this.deposit = deposit;
        this.availableBalance = availableBalance;
        this.accountId = accountId;
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

    public LocalDate getTransdate() {
        return transdate;
    }

    public void setTransdate(LocalDate transdate) {
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transid=" + transid +
                ", transdate=" + transdate +
                ", description='" + description + '\'' +
                ", chequeNumber=" + chequeNumber +
                ", withdraw=" + withdraw +
                ", deposit=" + deposit +
                ", availableBalance=" + availableBalance +
                ", accountId=" + accountId +
                '}';
    }


}
