package com.codegym.com.codegym.service;

import com.codegym.model.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int customerId);

    Map<Integer,Customer> update(int id,Customer customer);

}
