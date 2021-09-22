package com.customeroneproject.customer_one_project.model;


import lombok.Data;

import java.util.List;

@Data
public class CustomerModel {

    private Long customerId;
    private List<AccountModel> accounts;
    private String foreName;
    private String sureName;
    private String dateOfBirth;
}
