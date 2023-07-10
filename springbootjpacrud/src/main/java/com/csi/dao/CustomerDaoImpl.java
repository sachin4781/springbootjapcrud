package com.csi.dao;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerDaoImpl {

    @Autowired
    CustomerRepository customerRepositoryImpl;

    public Customer signup(Customer customer) {
        return customerRepositoryImpl.save(customer);
    }

    public boolean signin(String custemailid, String custpassword) {

        boolean flag = false;

        for (Customer customer : getalldata()) {
            if (customer.getCustemailid().equals(custemailid) && customer.getCustpassword().equals(custpassword)) {
                flag = true;
                break;
            }

        }
        return flag;
    }


    public List<Customer> getalldata() {
        return customerRepositoryImpl.findAll();
    }


    public Optional<Customer> getdatabyid(int custid) {

        return customerRepositoryImpl.findById(custid);
    }



    public Customer updatedata(Customer customer) {
        return customerRepositoryImpl.save(customer);
    }

    public void deletedatabyid(int custid) {
        customerRepositoryImpl.deleteById(custid);
    }
}
