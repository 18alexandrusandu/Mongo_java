package com.example.db_spring_mongo.repositories;

import com.example.db_spring_mongo.entity.Customers;
import com.example.db_spring_mongo.entity.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomersRepo  extends MongoRepository<Customers,String> {
    @Query("{name:'?0'}")
    Optional<Customers> findCustomerByName(String name);
}
