package javaorder.order.service;

import javaorder.order.model.Customers;

import java.util.ArrayList;

public interface CustomerService
{
    ArrayList<Customers> findAll();

    Customers findCustomerByName(String name);

    void delete(long id);

    Customers save(Customers customer);

    Customers update(Customers customer, long id);
}
