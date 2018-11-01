package project.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "card_operations")
public class CreditCard{
	@Id
	@Column(name = "cardnumber")
	@GeneratedValue(strategy = IDENTITY)
	private Integer cardNumber;
	@Column(name = "accountid")
	private Long accountId;

	public CreditCard(Long accountId) {
		this.accountId = accountId;
	}
	public Long getAccountId() {
		return accountId;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}



	public CreditCard() {
		// TODO Auto-generated constructor stub
	}

}
