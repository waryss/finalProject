package project.service;


import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import project.dao.AccountDao;
import project.dao.TransactionDao;
import project.dao.UserDao;
import project.exception.ProjectException;
import project.model.Account;

import project.model.Transaction;

import project.model.User;

import javax.transaction.Transactional;
import java.security.InvalidParameterException;
import java.time.LocalDate;

@Service(value = "service")
public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private AccountDao accountDao;
/*	@Autowired
	private TransactionDao transactionDao;*/

	public User authenticate(String login, String password) throws ProjectException {

		if (StringUtils.isEmpty(login))
			throw new InvalidParameterException("[login] is mandatory");

		if (StringUtils.isEmpty(password))
			throw new InvalidParameterException("[password] is mandatory");
		return userDao.findByLoginAndPassword(login, password)
				.orElseThrow(() -> new ProjectException("Could not found user for given login and password"));
	}

	public Account createAccount(String name, String dob, String address, String email, String type)
			throws ProjectException {
		Account newAccount = new Account(name, LocalDate.parse(dob), address, email, type);
		System.out.println(newAccount);
		accountDao.persist(newAccount);
		
		return newAccount;
	}
	
	public Account getAccount(int accountid) {
		return accountDao.find(accountid);
	}
	
	
	public void deposit(Account account,double amount)
	{
		double balance =account.getBalance();
		balance += amount; 
		account.setBalance(balance);
		accountDao.merge(account);
	}
	
	public void withdraw(Account account,double amount)
	{
		double balance =account.getBalance();
		balance -= amount;
		account.setBalance(balance);
		accountDao.merge(account);
	}

	/*public Transaction createTransaction(Integer transid, Date transdate, String description, Integer chequeNumber, Integer withdraw,
			Integer deposit, String availableBalance)
					throws ProjectException {
		Transaction transaction = new Transaction(transid, transdate, description, chequeNumber, withdraw, deposit, availableBalance);
		return transaction;
	}*/
}
