package project.dao.impl;

import org.springframework.stereotype.Repository;

import project.dao.AccountDao;
import project.model.Account;
import project.model.Customer;

@Repository
public class AccountDaoImpl extends GenericDaoImpl<Account, Integer> implements AccountDao {

}
