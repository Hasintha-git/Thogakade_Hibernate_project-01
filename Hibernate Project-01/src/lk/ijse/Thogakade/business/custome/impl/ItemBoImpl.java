package lk.ijse.Thogakade.business.custome.impl;

import lk.ijse.Thogakade.business.custome.ItemBo;
import lk.ijse.Thogakade.dao.DaoFactory;
import lk.ijse.Thogakade.dao.DaoType;
import lk.ijse.Thogakade.dao.custome.ItemDao;
import lk.ijse.Thogakade.dto.ItemDto;
import lk.ijse.Thogakade.entity.Item;

import java.util.List;

public class ItemBoImpl implements ItemBo {
ItemDao itemDao;
    public ItemBoImpl()
    {
        this.itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoType.ITEM);
    }
    @Override
    public boolean addItem(ItemDto item) throws Exception {
        return this.itemDao.add(new Item(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQty()));
    }

    @Override
    public boolean deleteItem(String id) throws Exception {
        return this.itemDao.delete(id);
    }

    @Override
    public boolean updateItem(ItemDto item) throws Exception {
        return this.itemDao.update(new Item(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQty()));
    }

    @Override
    public Item findItem(String id) throws Exception {
        return this.itemDao.find(id);
    }

    @Override
    public List<Item> findAll() throws Exception {
        return this.itemDao.findAll();
    }

    @Override
    public String getLastId() throws Exception {
        return this.itemDao.getLastId();
    }


}
