package org.example.h7.webshop.customer;

import org.example.h7.webshop.Database;
import org.example.h7.webshop.customer.Customer;

import java.util.List;

public class CustomerRepo {
    // Alleen CRUD operaties;


    public void add(String residence, String name) {
        Database.customers.add(new Customer(residence, name));
    }


    public List<Customer> findAll() {
        return Database.customers;
    }

    public List<Customer> findBy(String name) {
        return Database.customers.stream()
                .filter(c -> c.getName().equals(name))
                .toList();
    }
}
