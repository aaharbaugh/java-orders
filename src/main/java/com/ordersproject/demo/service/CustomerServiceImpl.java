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
    public Customers update(Customers customer, long id)
    {
       Customers currentCustomer = custrepos.findById(id)
               .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

       if(customer.getCustname() != null)
       {
           currentCustomer.setCustname(customer.getCustname());
       }

        if(customer.getCustcity() != null)
        {
            currentCustomer.setCustcity(customer.getCustcity());
        }

        if(customer.getWorkingarea() != null)
        {
            currentCustomer.setWorkingarea(customer.getWorkingarea());
        }

        if(customer.getCustcountry() != null)
        {
            currentCustomer.setCustcountry(customer.getCustcountry());
        }

        if(customer.getGrade() != null)
        {
            currentCustomer.setGrade(customer.getGrade());
        }

        if(customer.getOpeningamt() == 0.0)
        {
            currentCustomer.setOpeningamt(customer.getOpeningamt());
        }

        if(customer.getReceiveamt() == 0.0)
        {
            currentCustomer.setReceiveamt(customer.getReceiveamt());
        }

        if(customer.getPaymentamt() == 0.0)
        {
            currentCustomer.setPaymentamt(customer.getPaymentamt());
        }

        if(customer.getOutstandingamt() == 0.0)
        {
            currentCustomer.setOutstandingamt(customer.getOutstandingamt());
        }

        if(customer.getPhone() != null)
        {
            currentCustomer.setPhone(customer.getPhone());
        }

        if(customer.getGrade() != null)
        {
            currentCustomer.setGrade(customer.getGrade());
        }

        if(customer.getAgent() != null)
        {
            currentCustomer.setAgent((customer.getAgent()));
        }

        return custrepos.save(currentCustomer);
    }
}
