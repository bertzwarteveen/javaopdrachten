package org.example.h7.webshop;

import org.example.h7.webshop.catalog.Catalog;
import org.example.h7.webshop.customer.Customer;
import org.example.h7.webshop.item.Item;
import org.example.h7.webshop.order.Order;

import java.math.BigDecimal;
import java.util.*;

public class Database {
    public static final List<Item> items = new ArrayList<>((Arrays.asList(
            new Item(1, BigDecimal.valueOf(50), "Kaas", 2023),
            new Item(2, BigDecimal.valueOf(10), "Brood", 2023),
            new Item(3, BigDecimal.valueOf(35), "Melk", 2023),
            new Item(4, BigDecimal.valueOf(2), "Eieren", 2023),
            new Item(5, BigDecimal.valueOf(7), "Boter", 2023),
            new Item(6, BigDecimal.valueOf(20), "Appels", 2023),
            new Item(7, BigDecimal.valueOf(15), "Sinaasappels", 2023),
            new Item(8, BigDecimal.valueOf(12), "Bananen", 2023),
            new Item(9, BigDecimal.valueOf(8), "Pasta", 2023),
            new Item(10, BigDecimal.valueOf(5), "Rijst", 2023),
            new Item(11, BigDecimal.valueOf(55), "Chocolade", 2024),
            new Item(12, BigDecimal.valueOf(8), "Broccoli", 2024),
            new Item(13, BigDecimal.valueOf(4), "Yoghurt", 2024),
            new Item(14, BigDecimal.valueOf(3), "Tomaten", 2024),
            new Item(15, BigDecimal.valueOf(6), "Olijfolie", 2024),
            new Item(16, BigDecimal.valueOf(18), "Peren", 2024),
            new Item(17, BigDecimal.valueOf(14), "Druiven", 2024),
            new Item(18, BigDecimal.valueOf(10), "Aardbeien", 2024),
            new Item(19, BigDecimal.valueOf(9), "Lasagne", 2024),
            new Item(20, BigDecimal.valueOf(6), "Quinoa", 2024)
    )));
    public static final List<Order> orders = new ArrayList<>((Arrays.asList(
            new Order(new Date(23 - 12 - 2024), BigDecimal.valueOf(25),
                    new Customer("Arnhem", "Karel"),
                    new HashMap<>()
            ))));

    public static final List<Catalog> catalogs = new ArrayList<>((Arrays.asList(
            new Catalog(2023, items.subList(0, 10)),
            new Catalog(2024, items.subList(10, 20))
    )));

    public static final List<Customer> customers = new ArrayList<>((Arrays.asList(
            new Customer("Kreta", "Henkie"),
            new Customer("Kreta2", "Henkie"),
            new Customer("Kretas", "Henkie")
    )));

}

