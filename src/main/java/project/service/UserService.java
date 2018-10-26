package project.service;

import java.security.InvalidParameterException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder;

import project.dao.AccountDao;
import project.dao.UserDao;
import project.exception.ProjectException;
import project.model.Account;
import project.model.Customer;
import project.model.User;

@Service(value = "service")
public class UserService {

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

	public Account createAccount(String name, String dob, String adress, String email, String type)
			throws ProjectException {
		Account newAccount = new Account(name, LocalDate.parse(dob), adress, email, type);
		System.out.println(newAccount);
		customerDao.persist(newAccount);
		customerDao.flush();
		return newAccount;
	}
}
