package lk.ijse.Thogakade.dao.custome;

import lk.ijse.Thogakade.dao.SuperDao;
import lk.ijse.Thogakade.entity.Item;

public interface ItemDao extends SuperDao< Item , String> {
    String getLastId() throws Exception;


}
