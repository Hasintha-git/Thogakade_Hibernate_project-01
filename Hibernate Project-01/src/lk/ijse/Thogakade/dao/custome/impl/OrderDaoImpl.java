package lk.ijse.Thogakade.dao.custome.impl;

import lk.ijse.Thogakade.dao.custome.OrderDao;
import lk.ijse.Thogakade.entity.Orderr;
import lk.ijse.Thogakade.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class OrderDaoImpl implements OrderDao {
    public OrderDaoImpl(){

    }

    @Override
    public boolean add(Orderr entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Orderr entity) throws Exception {
        return false;
    }

    @Override
    public Orderr find(String s) throws Exception {
        return null;
    }

    @Override
    public List<Orderr> findAll() throws Exception {
        return null;
    }

    @Override
    public String getLastId() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("SELECT oid FROM orderr ORDER BY oid DESC LIMIT 1");
        String id = sqlQuery.uniqueResult().toString();
        transaction.commit();
        session.close();
        return id;
    }
}
