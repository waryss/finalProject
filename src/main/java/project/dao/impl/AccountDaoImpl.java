package project.dao.impl;

import org.springframework.stereotype.Repository;
import project.dao.AccountDao;
import project.model.Account;

@Repository
public class AccountDaoImpl extends GenericDaoImpl<Account, Long> implements AccountDao {

}
