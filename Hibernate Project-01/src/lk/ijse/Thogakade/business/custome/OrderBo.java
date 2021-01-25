package lk.ijse.Thogakade.business.custome;

import lk.ijse.Thogakade.business.SuperBo;
import lk.ijse.Thogakade.dto.CustomerDto;
import lk.ijse.Thogakade.dto.ItemDto;
import lk.ijse.Thogakade.dto.OrderDetailDto;
import lk.ijse.Thogakade.dto.OrderDto;

import java.util.List;

public interface OrderBo extends SuperBo {
    boolean placeOrder(CustomerDto customer, OrderDto order, List<OrderDetailDto>orderDetailList, List<ItemDto>itemDtoList)throws Exception;
    String getLastId() throws Exception;
}
