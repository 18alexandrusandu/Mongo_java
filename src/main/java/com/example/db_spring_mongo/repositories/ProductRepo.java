package com.example.db_spring_mongo.repositories;

import com.example.db_spring_mongo.entity.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepo extends MongoRepository<Products,String> {

    @Query("{name:'?0'}")
    Optional<Products> findItemByName(String name);


    @Query(value="{category:'?0'}")
    List<Products> findAllByCategory(String category);

    @Query(value="{quantity:{$gte:'?0'}}")
    List<Products> findQuantityGt(Integer quantity);


    public long count();
}
