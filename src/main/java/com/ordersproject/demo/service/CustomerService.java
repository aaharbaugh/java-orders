package com.ordersproject.demo.service;

import com.ordersproject.demo.model.Customers;

import java.util.ArrayList;

public interface CustomerService
{
    ArrayList<Customers> findAll();

    Customers findCustomersByCustname(String custname);

    void delete(long id);

    Customers save(Customers customer);

    Customers update(Customers customer, long id);
}
