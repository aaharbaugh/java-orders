package com.ordersproject.demo.controller;

import com.ordersproject.demo.model.Customers;
import com.ordersproject.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
public class CustomersController
{

    @Autowired
    private CustomerService customerService;

    //recieve list of all customers
    @GetMapping(value = "/order",
            produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        ArrayList<Customers> myList = customerService.findAll();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    //find customer by name
    @GetMapping(value = "/name/{custname}",
            produces = {"application/json"})
    public ResponseEntity<?> getCustomerByName(
            @PathVariable
                    String custname)
    {
        Customers c = customerService.findCustomersByCustname(custname);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    //create new customer
    @PostMapping(value = "data/new",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid
                                              @RequestBody Customers newCustomer)
    {
        newCustomer = customerService.save(newCustomer);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{restaurantid}").buildAndExpand(newCustomer.getCustcode()).toUri();
        responseHeaders.setLocation(newCustomerUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/data/update/{customerid}",
            consumes = {"application/json"})
    public ResponseEntity<?> updateCustomerById(
            @RequestBody
                    Customers updateCustomer,
            @PathVariable
                    long customerid)
    {
        customerService.update(updateCustomer, customerid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
