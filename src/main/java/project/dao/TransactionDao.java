package project.dao;

import project.model.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionDao extends GenericDao<Transaction, Integer> {
    public List<Transaction> getStatement(Long accountId, LocalDate dateFrom, LocalDate dateTo);
}

