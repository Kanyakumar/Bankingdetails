package com.customeroneproject.customer_one_project;

import com.customeroneproject.customer_one_project.entity.Account;
import com.customeroneproject.customer_one_project.entity.Customer;
import com.customeroneproject.customer_one_project.repository.AccountRepository;
import com.customeroneproject.customer_one_project.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class CustomerOneProjectApplication {



	public static void main(String[] args) {
		SpringApplication.run(CustomerOneProjectApplication.class, args);


	}

}
