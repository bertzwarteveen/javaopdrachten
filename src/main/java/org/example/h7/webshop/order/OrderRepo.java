package org.example.h7.webshop.order;

import org.example.h7.webshop.Database;
import org.example.h7.webshop.item.Item;
import org.example.h7.webshop.customer.Customer;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class OrderRepo {

    public void create(BigDecimal price, Customer customer, Map<Item, Integer> itemList) {
        Database.orders.add(new Order(Date.valueOf(LocalDate.now()), price, customer, itemList));
    }

    public List<Order> findAll() {
        return Database.orders;
    }

    public List<Order> findBy(Customer customer) {
        return Database.orders.stream()
                .filter(c -> c.getCustomer() == customer)
                .toList();
    }
}
