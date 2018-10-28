package project.dao.impl;

import org.springframework.stereotype.Repository;
import project.dao.TransactionDao;
import project.model.Transaction;

@Repository
public class TransactionDaoImpl extends GenericDaoImpl<Transaction, Integer> implements TransactionDao {

}
