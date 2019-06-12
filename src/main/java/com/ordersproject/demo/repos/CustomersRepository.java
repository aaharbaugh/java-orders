package com.ordersproject.demo.repos;

import com.ordersproject.demo.model.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customers, Long>
{
    Customers findCustomersByCustname(String name);
}
