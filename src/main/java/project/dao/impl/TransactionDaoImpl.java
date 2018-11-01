package project.dao.impl;

import org.springframework.stereotype.Repository;
import project.dao.TransactionDao;
import project.model.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

@Repository
public class TransactionDaoImpl extends GenericDaoImpl<Transaction, Integer> implements TransactionDao {

    public List<Transaction> getStatement(Long accountId, LocalDate dateFrom, LocalDate dateTo) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Transaction> query = builder.createQuery(Transaction.class);
        Root<Transaction> root = query.from(Transaction.class);
        query.where(builder.equal(root.get("accountId"), accountId)).where(builder.between(root.get("transdate"), dateFrom, dateTo));
        return getEntityManager().createQuery(query).getResultList();
    }
}