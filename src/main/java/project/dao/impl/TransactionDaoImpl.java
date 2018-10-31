package project.dao.impl;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import project.dao.TransactionDao;
import project.model.Transaction;

@Repository
public class TransactionDaoImpl extends GenericDaoImpl<Transaction, Integer> implements TransactionDao {
	
	public List<Transaction> getStatement(Long accountNumber,LocalDate dateFrom,LocalDate dateTo){
    	String hql = "From account_transactions where  accountid="+accountNumber+" and date between "+dateFrom+"and"+dateTo;
    	TypedQuery<Transaction> statementList = (TypedQuery<Transaction>) super.getEntityManager().createQuery(hql);
    	return statementList.getResultList();
	}
}
