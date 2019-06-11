package javaorder.order.service;


import javaorder.order.model.Customers;
import javaorder.order.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomersRepository custrepos;

    @Override
    public ArrayList<Customers> findAll() {
        ArrayList<Customers> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customers findCustomerByName(String name) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Customers save(Customers customer) {
        return null;
    }

    @Override
    public Customers update(Customers customer, long id) {
        return null;
    }
}
