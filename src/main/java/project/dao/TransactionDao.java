package project.dao;

import project.model.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionDao extends GenericDao<Transaction, Integer> {
	public List<Transaction> getStatement(Long accountId, Date dateFrom, Date dateTo);
}

