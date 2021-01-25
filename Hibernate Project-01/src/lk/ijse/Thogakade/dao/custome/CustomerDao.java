package lk.ijse.Thogakade.dao.custome;

import lk.ijse.Thogakade.dao.SuperDao;
import lk.ijse.Thogakade.entity.Customer;

public interface CustomerDao extends SuperDao<Customer, String> {
    String getLastId() throws Exception;
}
