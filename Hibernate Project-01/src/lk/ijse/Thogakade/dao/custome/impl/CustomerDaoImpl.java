package lk.ijse.Thogakade.dao.custome.impl;

import lk.ijse.Thogakade.dao.custome.CustomerDao;
import lk.ijse.Thogakade.entity.Customer;
import lk.ijse.Thogakade.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDaoImpl  implements CustomerDao {
    public CustomerDaoImpl() {
    }

    @Override
    public boolean add(Customer entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);

        session.delete(customer);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Customer entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Customer find(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        transaction.commit();
        session.close();
        return customer;
    }

    @Override
    public List<Customer> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Customer");
        List<Customer> list = query.list();


        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String getLastId() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("SELECT id FROM customer ORDER BY id DESC LIMIT 1");
        String id = sqlQuery.uniqueResult().toString();
        transaction.commit();
        session.close();
        return id;
    }
}
