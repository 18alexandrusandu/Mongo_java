package com.example.db_spring_mongo;

import com.example.db_spring_mongo.Services.ServiceCustomers;
import com.example.db_spring_mongo.Services.ServiceProducts;
import com.example.db_spring_mongo.entity.Products;
import com.example.db_spring_mongo.models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitLoader implements ApplicationRunner {
    @Autowired
    ServiceCustomers servc;
    @Autowired
    ServiceProducts servp;

    @Override
    public void run(ApplicationArguments args) throws Exception {
          System.out.println("Data creation started...");
            servp.createProduct(new ProductModel("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
            servp.createProduct(new ProductModel("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
            servp.createProduct(new ProductModel("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
            servp.createProduct(new ProductModel("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
            servp.createProduct(new ProductModel("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
            System.out.println("Data creation complete...");

    }
}
