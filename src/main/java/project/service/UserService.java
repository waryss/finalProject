package project.service;

import java.security.InvalidParameterException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder;

import project.dao.CustomerDao;
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
	private CustomerDao customerDao;

	public User authenticate(String login, String password) throws ProjectException {

		if (StringUtils.isEmpty(login))
			throw new InvalidParameterException("[login] is mandatory");

		if (StringUtils.isEmpty(password))
			throw new InvalidParameterException("[password] is mandatory");
		System.out.println("dans la finction userDao = " + userDao);
		return userDao.findByLoginAndPassword(login, password)
				.orElseThrow(() -> new ProjectException("Could not found user for given login and password"));
	}

	public Customer createCustomer(String name, String dob, String adress, String email, String type)
			throws ProjectException {
		Customer newCustomer = new Customer(name, LocalDate.parse(dob), adress, email, new Account(type));
		System.out.println(newCustomer);
		customerDao.persist(newCustomer);
		return newCustomer;
	}
}
