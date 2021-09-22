package com.customeroneproject.customer_one_project.entity;


import com.customeroneproject.customer_one_project.model.AccountModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Customer")
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long customerId;
    @Column
    private String foreName;
    @Column
    private  String sureName;
    @Column
    private String dateOfBirth;



    @OneToMany(targetEntity = Account.class)
    private Set<AccountModel> Accounts;



}
