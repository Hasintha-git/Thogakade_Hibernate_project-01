package lk.ijse.Thogakade.dao.custome;

import lk.ijse.Thogakade.dao.SuperDao;
import lk.ijse.Thogakade.entity.Orderr;

public interface OrderDao extends SuperDao< Orderr, String > {
    String getLastId() throws Exception;
}
