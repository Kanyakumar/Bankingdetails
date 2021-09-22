package com.customeroneproject.customer_one_project.entity;


import com.customeroneproject.customer_one_project.model.AccountModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Data
@Table(name = "Account")
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long accountId;

    @Column
    private Integer accountnumber;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinTable(name ="followed_customer",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name ="customer_id")
    )

    private List<Customer> customers;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AccountModel> Accounts;

}
