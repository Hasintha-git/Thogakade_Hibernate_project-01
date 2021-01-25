package lk.ijse.Thogakade.business;


import lk.ijse.Thogakade.business.custome.impl.CustomerBoImpl;
import lk.ijse.Thogakade.business.custome.impl.ItemBoImpl;
import lk.ijse.Thogakade.business.custome.impl.OrderBoImpl;
import lk.ijse.Thogakade.business.custome.impl.OrderDetailImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getInstance() {
        return boFactory == null ? (boFactory = new BoFactory()) : boFactory;
    }

    public <T extends SuperBo> T getBo(BoType boType) {
        switch(boType) {
            case CUSTOMER:
                return (T) new CustomerBoImpl();
            case ITEM:
                return (T) new ItemBoImpl();
            case ORDER:
                return (T) new OrderBoImpl();
            case ORDERDETAIL:
                return (T) new OrderDetailImpl();
            default:
                return null;
        }
    }
}
