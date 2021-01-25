package lk.ijse.Thogakade.dao.custome.impl;

import lk.ijse.Thogakade.dao.custome.ItemDao;
import lk.ijse.Thogakade.entity.Item;
import lk.ijse.Thogakade.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class ItemDaoImpl implements ItemDao {

    public ItemDaoImpl(){

    }
    @Override
    public boolean add(Item entity) throws Exception {
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
        Item item = session.get(Item.class, id);

        session.delete(item);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Item entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Item find(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Item item = session.get(Item.class, id);
        transaction.commit();
        session.close();
        return item;
    }

    @Override
    public List<Item> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Item");
        List<Item> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String getLastId() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("SELECT code FROM item ORDER BY code DESC LIMIT 1");
        String id = sqlQuery.uniqueResult().toString();
        transaction.commit();
        session.close();
        return id;
    }


}
