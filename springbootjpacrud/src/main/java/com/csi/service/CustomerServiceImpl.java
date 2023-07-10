package com.csi.service;

import com.csi.dao.CustomerDaoImpl;
import com.csi.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerServiceImpl {

    @Autowired
    CustomerDaoImpl customerDaoImpl;


    public Customer signup(Customer customer) {
        return customerDaoImpl.signup(customer);
    }

    public boolean signin(String custemailid, String custpassword) {

        return customerDaoImpl.signin(custemailid, custpassword);
    }


    public List<Customer> getalldata() {
        return customerDaoImpl.getalldata();
    }

    @Cacheable(value = "custid")
    public Optional<Customer> getdatabyid(int custid) {

        log.info("@@@@@@@Trying To Fetch Data From Db");

        return customerDaoImpl.getdatabyid(custid);
    }

    public Customer updatedata(Customer customer) {
        return customerDaoImpl.updatedata(customer);
    }

    public void deletedatabyid(int custid) {
        customerDaoImpl.deletedatabyid(custid);
    }
}
