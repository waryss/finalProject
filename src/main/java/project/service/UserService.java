package project.service;


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

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service(value = "service")
public class UserService {

    private final UserDao userDao;
    private final AccountDao accountDao;
    private final TransactionDao transactionDao;

    @Autowired
    public UserService(UserDao userDao, AccountDao accountDao, TransactionDao transactionDao) {
        this.userDao = userDao;
        this.accountDao = accountDao;
        this.transactionDao = transactionDao;
    }

    public User authenticate(String login, String password) throws ProjectException {

        if (StringUtils.isEmpty(login))
            throw new InvalidParameterException("[login] is mandatory");

        if (StringUtils.isEmpty(password))
            throw new InvalidParameterException("[password] is mandatory");
        return userDao.findByLoginAndPassword(login, password)
                .orElseThrow(() -> new ProjectException("Could not found user for given login and password"));
    }

    public Account createAccount(String name, String dob, String address, String email, String type) {
        Account newAccount = new Account(name, LocalDate.parse(dob), address, email, type);
        accountDao.persist(newAccount);

        return newAccount;
    }

    public Account getAccount(Long accountId) {
        return accountDao.find(accountId);
    }


    public void deposit(Account account, double amount) {
        account.addToAmount(amount);
        accountDao.merge(account);
    }

    public void withdraw(Account account, double amount) {
        account.subtractToAmount(amount);
        accountDao.merge(account);
    }

    public Transaction createTransaction(Date transdate, String description,  Integer withdraw,
                                         Integer deposit, Double availableBalance,Long accountId) {
        Transaction newTransaction=new Transaction(transdate, description,  withdraw, deposit, availableBalance,accountId);
        transactionDao.persist(newTransaction);
        return newTransaction;
    }
    
    public List<Transaction> displayStatement(Long accountNumber,String dateFrom,String dateTo){
    	return transactionDao.getStatement(accountNumber,LocalDate.parse(dateFrom),LocalDate.parse(dateTo));
    }
}
