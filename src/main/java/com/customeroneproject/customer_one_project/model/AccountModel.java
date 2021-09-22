package com.customeroneproject.customer_one_project.model;


import lombok.Data;

import java.util.List;

@Data
public class AccountModel {


    private Long accountId;
    private List<CustomerModel> customers;
    private Integer accountnumber;


}
