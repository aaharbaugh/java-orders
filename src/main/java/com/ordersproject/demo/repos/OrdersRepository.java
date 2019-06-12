package com.ordersproject.demo.repos;

import com.ordersproject.demo.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
}
