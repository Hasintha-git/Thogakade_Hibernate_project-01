package lk.ijse.Thogakade.business.custome;

import lk.ijse.Thogakade.business.SuperBo;
import lk.ijse.Thogakade.dto.CustomerDto;
import lk.ijse.Thogakade.entity.Customer;

import java.util.List;

public interface CustomerBo extends SuperBo {
    boolean addCustomer(CustomerDto customer) throws Exception;

    boolean deleteCustomer(String id) throws Exception;

    boolean updateCustomer(CustomerDto customer) throws Exception;

    public Customer findCustomer(String id) throws Exception;

    List<Customer> findAll() throws Exception;
    String getLastId() throws Exception;

}