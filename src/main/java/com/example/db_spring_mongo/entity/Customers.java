package com.example.db_spring_mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("customer")
public class Customers {
    @Id
    private String id;

    private String name;

    private String phone;

    private String Cnp;

    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCnp() {
        return Cnp;
    }

    public void setCnp(String cnp) {
        Cnp = cnp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customers(String id, String name, String phone, String cnp, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        Cnp = cnp;
        this.email = email;
    }
}
