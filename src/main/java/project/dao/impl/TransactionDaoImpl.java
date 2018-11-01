package project.dao.impl;

import java.time.LocalDate;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;



import org.springframework.stereotype.Repository;
import project.dao.TransactionDao;
import project.model.Transaction;

@Repository
public class TransactionDaoImpl extends GenericDaoImpl<Transaction, Integer> implements TransactionDao {

    public List<Transaction> getStatement(Long accountId,LocalDate dateFrom, LocalDate dateTo) {
        CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
        return getByCriteria(criteriaBuilder.between(getRoot(criteriaBuilder).get("date"), dateFrom, dateTo));
       /*         criteriaBuilder.and(criteriaBuilder.equal(getRoot(criteriaBuilder).get("accountid"),accountId))*/
    }
}