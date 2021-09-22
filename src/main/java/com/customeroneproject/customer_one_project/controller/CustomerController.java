package com.customeroneproject.customer_one_project.controller;


import com.customeroneproject.customer_one_project.entity.Customer;
import com.customeroneproject.customer_one_project.model.CustomerModel;
import com.customeroneproject.customer_one_project.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/service")
@Log4j2
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/all_customers")
    public ResponseEntity<List> customer(){

        return ResponseEntity.ok().body(customerService.getCustomer());
    }

    @PostMapping(value = "/customer")
    public ResponseEntity<Customer> customer(@RequestBody Customer cust){
        log.info("Inside post");
        var customer = customerService.saveCustomer(cust);
        return ResponseEntity.ok().body(customer);

    }

    @GetMapping(value = "/customer")
    public ResponseEntity<Optional<Customer>> customer(@RequestParam Long customerId){
        var customer = customerService.getCustomer(customerId);
        return ResponseEntity.ok().body(customer);
    }

    @PutMapping(value = "/customer")
    public ResponseEntity<Customer> updateCustomer(@RequestParam Long customerId,@RequestBody CustomerModel cust){
        return ResponseEntity.ok().body(customerService.updateCustomer(customerId,cust));
    }
}
