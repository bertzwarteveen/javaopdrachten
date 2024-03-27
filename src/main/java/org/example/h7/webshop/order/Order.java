package org.example.h7.webshop.order;

import org.example.h7.webshop.customer.Customer;
import org.example.h7.webshop.item.Item;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private Date date; // kan date class adden
    private BigDecimal totalPrice;
    private Customer customer;
    private Map<Item, Integer> items = new HashMap<>();

    public Date getDate() {
        return date;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public Order(Date date, BigDecimal totalPrice, Customer customer, Map<Item, Integer> items) {
        this.date = date;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.items = items;
    }

    public void add(Item orderedItem) {
        items.put(orderedItem, items.getOrDefault(orderedItem, 0) + 1);
    }

    // Toevoegen dat elk item wat dubbel voorkomt gewoon 1 keer op het bonnentje verschijnt
    @Override
    public String toString() {
        String orderReceipt = "Receipt\n";
        String dateString = "Date: " + date + "\n";
        StringBuilder itemsString = new StringBuilder();

        for (Map.Entry<Item, Integer> i : items.entrySet()) {
            String description = i.getKey().getDescription();
            int quantity = i.getValue();
            String totalPrice = i.getKey().getPrice().multiply(BigDecimal.valueOf(quantity)).toString();
            itemsString.append(quantity).append("x ").append(description).append(" ")
                    .append(" €").append(totalPrice).append(",-\n");
        }

        String totalPrice = "Total price: " + "€" + getTotalPrice().toString() + ",-";

        return orderReceipt + dateString + itemsString + totalPrice;
    }


}
