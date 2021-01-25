package lk.ijse.Thogakade.dao.custome.impl;

import lk.ijse.Thogakade.dao.custome.OrderDetailDao;
import lk.ijse.Thogakade.entity.OrderDetail;
import lk.ijse.Thogakade.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderDetileDaoImpl implements OrderDetailDao {
    @Override
    public boolean add(OrderDetail entity) throws Exception {
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
    public boolean update(OrderDetail entity) throws Exception {
        return false;
    }

    @Override
    public OrderDetail find(String s) throws Exception {
        return null;
    }

    @Override
    public List<OrderDetail> findAll() throws Exception {
        return null;
    }
}
