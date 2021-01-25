package lk.ijse.Thogakade.dao;

import lk.ijse.Thogakade.dao.custome.impl.CustomerDaoImpl;
import lk.ijse.Thogakade.dao.custome.impl.ItemDaoImpl;
import lk.ijse.Thogakade.dao.custome.impl.OrderDaoImpl;
import lk.ijse.Thogakade.dao.custome.impl.OrderDetileDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return daoFactory == null ? (daoFactory = new DaoFactory()) : daoFactory;
    }

    public <T extends SuperDao> T getDao(DaoType daoType) {
        switch(daoType) {
            case CUSTOMER:
                return (T) new CustomerDaoImpl();
            case ITEM:
                return (T) new ItemDaoImpl();
            case ORDER:
                return (T) new OrderDaoImpl();
            case ORDEDETAIL:
                return (T) new OrderDetileDaoImpl();
            default:
                return null;
        }
    }
}
