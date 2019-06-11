package javaorder.order.repos;

import org.springframework.data.repository.CrudRepository;
import javaorder.order.model.Customers;

public interface CustomersRepository extends CrudRepository<Customers, Long>
{
}
