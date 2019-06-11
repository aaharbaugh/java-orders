package javaorder.order.repos;

import javaorder.order.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
}
