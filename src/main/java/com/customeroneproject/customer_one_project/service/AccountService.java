package com.customeroneproject.customer_one_project.service;


import com.customeroneproject.customer_one_project.entity.Account;
import com.customeroneproject.customer_one_project.entity.Customer;
import com.customeroneproject.customer_one_project.model.AccountModel;
import com.customeroneproject.customer_one_project.model.CustomerModel;
import com.customeroneproject.customer_one_project.repository.AccountRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;
import springfox.documentation.swagger2.mappers.ModelMapperImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    ModelMapper modelMapper = new ModelMapperImpl();

    public Account saveAccount(Account acc) {
        var account = accountRepository.save(acc);
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountId(account.getAccountId());
        accountModel.setAccountnumber(account.getAccountnumber());
        return account;
    }
    public Optional<Account> getAccount(Long accountId){
        var account = accountRepository.findById(accountId);
        return account;

    }
    public List getAccount(){
        List acct = new ArrayList<Account>();
        accountRepository.findAll().forEach(acct::add);
        return acct;
    }

    public Account updateAccount(Long accountId,AccountModel account){
        modelMapper.getClass().equals(true);
        var exisitingAccount = getAccount(accountId).get();
//        modelMapper.mapModels(account,exisitingAccount);
        return accountRepository.save(exisitingAccount);

    }


}
