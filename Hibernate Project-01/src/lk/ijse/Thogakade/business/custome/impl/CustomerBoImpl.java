package lk.ijse.Thogakade.business.custome.impl;

import lk.ijse.Thogakade.business.custome.CustomerBo;
import lk.ijse.Thogakade.dao.DaoFactory;
import lk.ijse.Thogakade.dao.DaoType;
import lk.ijse.Thogakade.dao.custome.CustomerDao;
import lk.ijse.Thogakade.dto.CustomerDto;
import lk.ijse.Thogakade.entity.Customer;

import java.util.List;

public class CustomerBoImpl implements CustomerBo {
    CustomerDao customerDao;

    public CustomerBoImpl() {
        this.customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoType.CUSTOMER);
    }

    public boolean addCustomer(CustomerDto customerDto) throws Exception {
        return this.customerDao.add(new Customer(customerDto.getId(), customerDto.getName(), customerDto.getAddress()));
    }

    public boolean deleteCustomer(String id) throws Exception {
        return this.customerDao.delete(id);
    }

    public boolean updateCustomer(CustomerDto customer) throws Exception {
        return this.customerDao.update(new Customer(customer.getId(), customer.getName(), customer.getAddress()));
    }

    @Override
    public Customer findCustomer(String id) throws Exception {
        return this.customerDao.find(id);
    }

    @Override
    public List<Customer> findAll() throws Exception {
        return this.customerDao.findAll();
    }

    @Override
    public String getLastId() throws Exception {
        return this.customerDao.getLastId();
    }
}