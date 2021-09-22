package com.customeroneproject.customer_one_project .service;


import com.customeroneproject.customer_one_project.entity.Account;
import com.customeroneproject.customer_one_project.entity.Customer;
import com.customeroneproject.customer_one_project.model.AccountModel;
import com.customeroneproject.customer_one_project.model.CustomerModel;
import com.customeroneproject.customer_one_project.repository.AccountRepository;
import com.customeroneproject.customer_one_project.repository.CustomerRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;
import springfox.documentation.swagger2.mappers.ModelMapperImpl;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    public CustomerService(CustomerRepository customerRepository,AccountRepository accountRepository){
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }



    ModelMapper modelMapper = new ModelMapperImpl();

    public Customer saveCustomer(Customer cust){
        var customer = customerRepository.save(cust);
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomerId(customer.getCustomerId());
//        customerModel.setAccountId(customer.getAccountId());
        customerModel.setForeName(customer.getForeName());
        customerModel.setSureName(customer.getSureName());
        customerModel.setDateOfBirth(customer.getDateOfBirth());
        return customer;
    }

    public Optional<Customer> getCustomer(Long customerId){
        var customer = customerRepository.findById(customerId);
        return customer;
    }

    public List getCustomer(){
        List custs = new ArrayList<Customer>();
        customerRepository.findAll().forEach(custs::add);
        return custs;

    }

    public Customer updateCustomer(Long customerId,CustomerModel customer){
        modelMapper.getClass().equals(true);
        var exisitingCustomer = getCustomer(customerId).get();
//        modelMapper.map(customer,exisitingCustomer);
        return customerRepository.save(exisitingCustomer);
    }


}


