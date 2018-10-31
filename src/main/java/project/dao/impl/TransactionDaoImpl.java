package project.dao.impl;

import org.springframework.stereotype.Repository;
import project.dao.TransactionDao;
import project.model.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

@Repository
public class TransactionDaoImpl extends GenericDaoImpl<Transaction, Integer> implements TransactionDao {

    public List<Transaction> getStatement(LocalDate dateFrom, LocalDate dateTo) {
        CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
        return getByCriteria(criteriaBuilder.between(getRoot(criteriaBuilder).get("date"), dateFrom, dateTo));
    }
}
