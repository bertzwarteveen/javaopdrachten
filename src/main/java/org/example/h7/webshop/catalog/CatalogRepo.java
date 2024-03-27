package org.example.h7.webshop.catalog;

import org.example.h7.webshop.Database;
import org.example.h7.webshop.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CatalogRepo {
    // Alleen behaviour Catalog zelf heeft alleen getters, setters en constructors
    public void create(int year) {
        Database.catalogs.add(new Catalog(year, new ArrayList<>()));
    }

    public List<Catalog> findAll() {
        return Database.catalogs;
    }

    public List<Catalog> findBy(int year) {
        return Database.catalogs.stream()
                .filter(c -> c.getYear() == year)
                .toList();
    }

    public Optional<Item> findItemBy(int id, Catalog desiredCatalog) {
        int desiredYear = desiredCatalog.getYear();
        for (Catalog catalog : Database.catalogs) {
            if (catalog.getYear() == desiredYear) {
                return catalog.getItems().stream()
                        .filter(c -> c.getId() == id)
                        .findAny();
            }
        }
            return Optional.empty();
    }

    public List<Integer> findAvailableYears(){
        return Database.catalogs.stream()
                .map(Catalog::getYear)
                .collect(Collectors.toList());
    }
}

