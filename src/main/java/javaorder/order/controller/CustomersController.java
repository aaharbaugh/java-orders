package javaorder.order.controller;

import javaorder.order.model.Customers;
import javaorder.order.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.sql.SQLOutput;
import java.util.ArrayList;

@RestController
//@RequestMapping("/customer")
public class CustomersController
{

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/order",
            produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        ArrayList<Customers> myList = customerService.findAll();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

}
