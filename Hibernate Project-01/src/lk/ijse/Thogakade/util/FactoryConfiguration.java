package lk.ijse.Thogakade.util;

import lk.ijse.Thogakade.entity.Customer;
import lk.ijse.Thogakade.entity.Item;
import lk.ijse.Thogakade.entity.OrderDetail;
import lk.ijse.Thogakade.entity.Orderr;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Item.class).addAnnotatedClass(Orderr.class).addAnnotatedClass(OrderDetail.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
