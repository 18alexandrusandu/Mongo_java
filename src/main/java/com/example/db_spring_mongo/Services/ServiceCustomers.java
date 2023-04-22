package com.example.db_spring_mongo.Services;

import com.example.db_spring_mongo.entity.Customers;
import com.example.db_spring_mongo.entity.Products;
import com.example.db_spring_mongo.models.CustomerModel;
import com.example.db_spring_mongo.models.ProductModel;
import com.example.db_spring_mongo.repositories.CustomersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceCustomers {
    @Autowired
    CustomersRepo repo;

    public  Customers createCustomer(CustomerModel Customer)
    {
        Customers  newCustomer=new Customers(Customer.getId(),Customer.getName(),Customer.getPhone(),Customer.getCnp(),Customer.getEmail());
        Customers  prod=repo.save(newCustomer);

        return prod;
    }
    public  List<Customers> createCustomers(List<CustomerModel> customers)
    {   List<Customers> prods=new ArrayList<Customers>();
        for(CustomerModel Customer : customers) {
            Customers  newCustomer=new Customers(Customer.getId(),Customer.getName(),Customer.getPhone(),Customer.getCnp(),Customer.getEmail());
            Customers  prod=repo.save(newCustomer);
            prods.add(prod);
        }
        return prods;
    }
    public  Customers updateCustomer(CustomerModel Customer)
    {
        Customers newCustomer=new Customers(Customer.getId(),Customer.getName(),Customer.getPhone(),Customer.getCnp(),Customer.getEmail());
        Customers prod=repo.save(newCustomer);

        return prod;
    }
    public Customers readCustomerById(String Id)
    {
        Customers prod=null;
        if(repo.existsById(Id))
            prod=repo.findById(Id).get();

        return prod;
    }
    public  Customers readCustomerByName(String Name)
    {
        Customers prod=null;
        prod=repo.findCustomerByName(Name).get();

        return prod;
    }
    public List<Customers> readAllCustomer()
    {
        List<Customers> prods=null;

        prods=repo.findAll();

        return prods;
    }

    public Boolean deleteCustomer(String Id)
    {        if(repo.existsById(Id)) {
        Customers prod = repo.findById(Id).get();
        repo.delete(prod);
        return true;
    }
    else
        return false;

    }
    public Long findCountOfCustomers()
    {
        return Long.valueOf(repo.count());
    }
}
