package com.ordersproject.demo.service;


import com.ordersproject.demo.model.Agents;
import com.ordersproject.demo.model.Customers;
import com.ordersproject.demo.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Customers findCustomersByCustname(String custname)
    {
        Customers customer = custrepos.findCustomersByCustname(custname);

        if(customer == null)
        {
            throw new EntityNotFoundException("Customer with " + custname + " not found");
        }

        return customer;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Customers save(Customers customer)
    {
        Customers newCustomer = new Customers();

        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setAgent(customer.getAgent());

        return custrepos.save(newCustomer);
    }

    @Override
    public Customers update(Customers customer, long id) {
        return null;
    }
}
