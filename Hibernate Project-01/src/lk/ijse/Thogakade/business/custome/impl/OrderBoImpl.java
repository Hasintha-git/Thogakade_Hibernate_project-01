package lk.ijse.Thogakade.business.custome.impl;

import lk.ijse.Thogakade.business.custome.OrderBo;
import lk.ijse.Thogakade.dao.DaoFactory;
import lk.ijse.Thogakade.dao.DaoType;
import lk.ijse.Thogakade.dao.custome.CustomerDao;
import lk.ijse.Thogakade.dao.custome.ItemDao;
import lk.ijse.Thogakade.dao.custome.OrderDao;
import lk.ijse.Thogakade.dao.custome.OrderDetailDao;
import lk.ijse.Thogakade.dto.CustomerDto;
import lk.ijse.Thogakade.dto.ItemDto;
import lk.ijse.Thogakade.dto.OrderDetailDto;
import lk.ijse.Thogakade.dto.OrderDto;
import lk.ijse.Thogakade.entity.*;

import java.util.ArrayList;
import java.util.List;

public class OrderBoImpl implements OrderBo {
    OrderDao orderDao;
    CustomerDao customerDao;
    ItemDao itemDao;
    OrderDetailDao orderDetailDao;
    public OrderBoImpl(){
        orderDao= DaoFactory.getInstance().getDao(DaoType.ORDER);
        customerDao = DaoFactory.getInstance().getDao(DaoType.CUSTOMER);
        itemDao = DaoFactory.getInstance().getDao(DaoType.ITEM);
        orderDetailDao = DaoFactory.getInstance().getDao(DaoType.ORDEDETAIL);
    }




    @Override
    public boolean placeOrder(CustomerDto customer, OrderDto order, List<OrderDetailDto> orderDetailList, List<ItemDto> itemList) throws Exception {
        Customer customer1 = new Customer();
        customer1.setId(customer.getId());
        customer1.setName(customer.getName());
        customer1.setAddress(customer.getAddress());
        Orderr orderr = new Orderr();
        orderr.setid(order.getId());
        orderr.setPay(order.getPay());
        orderr.setTotal(order.getTot());

        orderr.setCustomer(customer1);


        List<OrderDetail> orderDetailList1 = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderr.setOrderDetails(orderDetailList1);
        orderDao.add(orderr);

        Item item = new Item();
        for (int i = 0; i < orderDetailList.size(); i++) {
            ForiengKey fKey=new ForiengKey();
            fKey.setOrId(orderDetailList.get(i).getId());
            fKey.setCode(orderDetailList.get(i).getCode());

            item = new Item(itemList.get(i).getCode(), itemList.get(i).getDescription(), itemList.get(i).getUnitPrice(), itemList.get(i).getQty(),orderDetailList1);

            orderDetail.setForiengKey(fKey);
            orderDetail.setOrderr(orderr);
            orderDetail.setItem(item);
            orderDetail.setQty(orderDetailList.get(i).getQty());
            orderDetail.setPrice( orderDetailList.get(i).getPrice());

            orderDetailDao.add(orderDetail);

        }
        return true;
    }

    @Override
    public String getLastId() throws Exception {
        return this.orderDao.getLastId();
    }
}
