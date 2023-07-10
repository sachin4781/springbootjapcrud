package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerServiceImpl;


    @PostMapping("/signup")
    public ResponseEntity<Customer> signup(@Valid @RequestBody Customer customer) {
        return new ResponseEntity<>(customerServiceImpl.signup(customer), HttpStatus.CREATED);
    }

    @GetMapping("/signin/{custemailid}/{custpassword}")

    public ResponseEntity<Boolean> signin(@PathVariable String custemailid, @PathVariable String custpassword) {
        return ResponseEntity.ok(customerServiceImpl.signin(custemailid, custpassword));
    }

    @GetMapping("/getdatabyid/{custid}")

    public ResponseEntity<Optional<Customer>> getdatabyid(@PathVariable int custid) {
        return ResponseEntity.ok(customerServiceImpl.getdatabyid(custid));
    }



    @GetMapping("/getalldata")

    public ResponseEntity<List<Customer>> getalldata() {
        return ResponseEntity.ok(customerServiceImpl.getalldata());
    }


    @PutMapping("/updatedata/{custid}")

    public ResponseEntity<Customer> updatedata(@PathVariable int custid, @Valid @RequestBody Customer customer) {

        Customer customer1 = customerServiceImpl.getdatabyid(custid).orElseThrow(() -> new RecordNotFoundException("Customer Id Does Not Exist..."));


        customer1.setCustaddress(customer.getCustaddress());
        customer1.setCustcontactnumber(customer.getCustcontactnumber());
        customer1.setCustdob(customer.getCustdob());
        customer1.setCustid(customer.getCustid());
        customer1.setCustemailid(customer.getCustemailid());
        customer1.setCustpassword(customer.getCustpassword());
        customer1.setCustname(customer.getCustname());
        customer1.setCustsalary(customer.getCustsalary());

        return new ResponseEntity<>(customerServiceImpl.updatedata(customer1), HttpStatus.CREATED);


    }

    @DeleteMapping("/deletedatabyid/{custid}")

    public ResponseEntity<String> deletedatabyid(@PathVariable int custid) {

        customerServiceImpl.deletedatabyid(custid);

        return ResponseEntity.ok("Data Deleted...");
    }


}
