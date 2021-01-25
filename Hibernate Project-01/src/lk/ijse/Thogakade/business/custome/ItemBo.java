package lk.ijse.Thogakade.business.custome;

import lk.ijse.Thogakade.business.SuperBo;
import lk.ijse.Thogakade.dto.ItemDto;
import lk.ijse.Thogakade.entity.Item;

import java.util.List;

public interface ItemBo extends SuperBo {
    boolean addItem(ItemDto item) throws Exception;

    boolean deleteItem(String id) throws Exception;

    boolean updateItem(ItemDto item) throws Exception;

    public Item findItem(String id) throws Exception;

    List<Item> findAll() throws Exception;

    String getLastId() throws Exception;


}
