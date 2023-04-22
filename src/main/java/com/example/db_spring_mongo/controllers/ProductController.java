package com.example.db_spring_mongo.controllers;

import com.example.db_spring_mongo.Services.ServiceCustomers;
import com.example.db_spring_mongo.Services.ServiceProducts;
import com.example.db_spring_mongo.entity.Customers;
import com.example.db_spring_mongo.entity.Products;
import com.example.db_spring_mongo.models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ServiceProducts serv;

    @PostMapping("product/add")
  void  addproduct(@RequestBody ProductModel model)
    { serv.createProduct(model);

    }

    @PostMapping("product/insertMore")
    List<Products> addproducts(@RequestBody List<ProductModel> list)
    {  return serv.createProducts(list);
    }

    @GetMapping("/product/delete/{id}")
    void  deleteproduct(@PathVariable("id") String id)
    {  serv.deleteProduct(id);

    }
    @PostMapping("product/update")
    void  updateproduct(@RequestBody ProductModel model)
    {  serv.updateProduct(model);
    }

    @GetMapping("product/all")
    List<Products> readAll()
    {  return serv.readAllProducts();
    }
    @GetMapping("product/name/{name}")
    Products readByName(@PathVariable("name") String name)
    {  return serv.readProductByName(name);
    }
    @GetMapping("product/quantity")
    Long readByName()
    {  return serv.findCountOfProducts();
    }
    @GetMapping("product/id/{id}")
    Products readById(@PathVariable("id") String  Id)
    {  return serv.readProductById(Id);
    }



}
