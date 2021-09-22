package com.customeroneproject.customer_one_project.controller;

import com.customeroneproject.customer_one_project.entity.Account;
import com.customeroneproject.customer_one_project.entity.Customer;
import com.customeroneproject.customer_one_project.model.AccountModel;
import com.customeroneproject.customer_one_project.model.CustomerModel;
import com.customeroneproject.customer_one_project.service.AccountService;
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
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping(value = "/all_accounts")
    public ResponseEntity<List> account(){

        return ResponseEntity.ok().body(accountService.getAccount());
    }

    @PostMapping(value = "/account")
    public ResponseEntity<Account> account(@RequestBody Account acc){
        log.info("Inside post");
        var account = accountService.saveAccount(acc);
        return ResponseEntity.ok().body(account);

    }

    @GetMapping(value = "/account")
    public ResponseEntity<Optional<Account>> account(@RequestParam Long accountId){
        var account = accountService.getAccount(accountId);
        return ResponseEntity.ok().body(account);
    }

    @PutMapping(value = "/account")
    public ResponseEntity<Account> updateCustomer(@RequestParam Long accountId,@RequestBody AccountModel acct){
        return ResponseEntity.ok().body(accountService.updateAccount(accountId,acct));
    }


}
