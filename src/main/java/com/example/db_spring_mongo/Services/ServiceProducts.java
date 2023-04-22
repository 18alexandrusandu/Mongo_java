package com.example.db_spring_mongo.Services;

import com.example.db_spring_mongo.entity.Products;
import com.example.db_spring_mongo.models.ProductModel;
import com.example.db_spring_mongo.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceProducts {
    @Autowired
    ProductRepo repo;
    public  Products createProduct(ProductModel product)
    {
        Products newProduct=new Products(product.getId(),product.getName(),product.getQuantity(),product.getCategory());
        Products prod=repo.save(newProduct);

        return prod;
    }
    public  List<Products> createProducts(List<ProductModel> products)
    {   List<Products> prods=new ArrayList<Products>();
        for(ProductModel product : products) {
        Products newProduct = new Products(product.getId(), product.getName(), product.getQuantity(), product.getCategory());
        Products prod = repo.save(newProduct);
         prods.add(prod);
            }
        return prods;
    }
    public Products updateProduct(ProductModel product)
    {
        Products newProduct=new Products(product.getId(),product.getName(),product.getQuantity(),product.getCategory());
        Products prod=repo.save(newProduct);

        return prod;
    }
    public Products readProductById(String Id)
    {
        Products prod=null;
        if(repo.existsById(Id))
         prod=repo.findById(Id).get();

        return prod;
    }
    public Products readProductByName(String Name)
    {
        Products prod=null;
            prod=repo.findItemByName(Name).get();

        return prod;
    }
    public  List<Products> readAllProducts()
    {
        List<Products> prods=null;

            prods=repo.findAll();

        return prods;
    }
    public List<Products> readAllByCategory(String category)
    {
        List<Products> prods=null;

        prods=repo.findAllByCategory(category);

        return prods;
    }
    public Boolean deleteProduct(String Id)
  {        if(repo.existsById(Id)) {
      Products prod = repo.findById(Id).get();
      repo.delete(prod);
      return true;
   }
   else
      return false;

  }
    public Long findCountOfProducts()
 {
     return Long.valueOf(repo.count());
 }
    public List<Products> findProductWithQuantityGt(Integer quantity)
    {
        return repo.findQuantityGt(quantity);

    }










}
