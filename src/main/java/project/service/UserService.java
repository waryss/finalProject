package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import project.dao.AccountDao;
import project.dao.UserDao;
import project.exception.ProjectException;
import project.model.Account;
import project.model.User;

import javax.transaction.Transactional;
import java.security.InvalidParameterException;
import java.time.LocalDate;

@Service(value = "service")
public class UserService {

<<<<<<< HEAD
    @Autowired
    private UserDao userDao;
    @Autowired
    private AccountDao customerDao;

    public User authenticate(String login, String password) throws ProjectException {

        if (StringUtils.isEmpty(login))
            throw new InvalidParameterException("[login] is mandatory");

        if (StringUtils.isEmpty(password))
            throw new InvalidParameterException("[password] is mandatory");
        return userDao.findByLoginAndPassword(login, password)
                .orElseThrow(() -> new ProjectException("Could not found user for given login and password"));
    }

    @Transactional
    public Account createAccount(String name, String dob, String adress, String email, String type)
            throws ProjectException {
        Account newAccount = new Account(name, LocalDate.parse(dob), adress, email, type);
        System.out.println(newAccount);
        customerDao.persist(newAccount);
        return newAccount;
    }
=======
	@Autowired
	private UserDao userDao;
	@Autowired
	private AccountDao customerDao;

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
		customerDao.persist(newAccount);
		
		return newAccount;
	}
	
	public double deposit(Account account,double amount)
	{
		double balance =account.getBalance();
		return balance += amount; 
	}
	
	public double withdraw(Account account,double amount)
	{
		double balance =account.getBalance();
		return balance -= amount;
	}
>>>>>>> ajout des transactions et des operations de retrait et depot dans le
}
