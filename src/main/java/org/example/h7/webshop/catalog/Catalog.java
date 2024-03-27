package org.example.h7.webshop.catalog;

import org.example.h7.webshop.item.Item;

import java.util.ArrayList;
import java.util.List;


public class Catalog {
    private int year;
    private List<Item> items = new ArrayList<>();

    public int getYear() {
        return year;
    }

    public List<Item> getItems() {
        return items;
    }


    public void add(Item newItem) {
        items.add(newItem);
    }


    public Catalog(int year, List<Item> items) {
        this.year = year;
        this.items = items;
    }

    @Override
    public String toString() {
        String catalogString = "Catalog Year: " + year + "\n";
        catalogString = catalogString.replace("[", "");
        String itemsString = "";
        for (Item item : items) {
            itemsString += item.toString();
        }
        return catalogString + itemsString;
    }

    ;

}
