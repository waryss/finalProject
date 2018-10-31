package project.dao;

import java.time.LocalDate;
import java.util.List;

import project.model.Transaction;

public interface TransactionDao extends GenericDao<Transaction, Integer> {
	public List<Transaction> getStatement(Integer accountNumber,LocalDate dateFrom,LocalDate dateTo);
}

