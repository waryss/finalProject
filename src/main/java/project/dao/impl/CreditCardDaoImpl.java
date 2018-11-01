package project.dao.impl;

import org.springframework.stereotype.Repository;
import project.dao.CreditCardDao;

import project.model.CreditCard;

@Repository
public class CreditCardDaoImpl extends GenericDaoImpl<CreditCard, Integer> implements CreditCardDao {
}
