package org.example.h7.webshop.item;

import org.example.h7.webshop.Database;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ItemRepo {

    public void create(BigDecimal price, String description, int year) {
       int id = Database.items.size() + 1;
        Database.items.add(new Item(id, price, description, year));
    }

    public List<Item> findAll() {
        return Database.items;
    }

    public Optional<Item> findBy(int id) {
        return Database.items.stream()
                .filter(c -> c.getId() == id)
                .findAny();
    }

}