package com.example.db_spring_mongo.controllers;

import com.example.db_spring_mongo.Services.ServiceCustomers;
import com.example.db_spring_mongo.entity.Customers;
import com.example.db_spring_mongo.entity.Products;
import com.example.db_spring_mongo.models.CustomerModel;
import com.example.db_spring_mongo.models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    ServiceCustomers serv;
    @PostMapping("customer/add")
    void  addproduct(@RequestBody CustomerModel model)
    { serv.createCustomer(model);

    }

    @PostMapping("customer/insertMore")
    List<Customers> addcustomers(@RequestBody List<CustomerModel> list)
    {  return serv.createCustomers(list);
    }
    @GetMapping("customer/delete/{id}")
    void  deleteproduct(@PathVariable("id") String id)
    {  serv.deleteCustomer(id);

    }
    @PostMapping("customer/update")
    void  updateproduct(@RequestBody CustomerModel model)
    {  serv.updateCustomer(model);
    }

    @GetMapping("customer/all")
    List<Customers> readAll()
    {  return serv.readAllCustomer();
    }

    @GetMapping("customer/name/{name}")
    Customers readByName(@PathVariable("name") String name)
    {  return serv.readCustomerByName(name);
    }

    @GetMapping("customer/id/{id}")
    Customers readById(@PathVariable("id") String  Id)
    {  return serv.readCustomerById(Id);
    }

    @GetMapping("customer/number")
    Long readCount()
    {  return serv.findCountOfCustomers();
    }


}
