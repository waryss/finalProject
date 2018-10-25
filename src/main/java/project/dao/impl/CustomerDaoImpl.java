package project.dao.impl;

import org.springframework.stereotype.Repository;

import project.dao.CustomerDao;
import project.model.Customer;

@Repository
public class CustomerDaoImpl extends GenericDaoImpl<Customer, Integer> implements CustomerDao {

}
