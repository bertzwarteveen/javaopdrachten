package org.example.h7.webshop.item;

import java.math.BigDecimal;

public class Item {
    private int id;
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {
        return year;
    }

    private String description;
    private int year;

    public Item(int id, BigDecimal price, String description, int year) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.year = year;
    }




    @Override
    public String toString() {
        return id + " " + description + " €" + price + ",-" +"\n";
    }


    // Mogelijk toevoegen
//    public void addToCatalog (Item newItem){
    //       getCatalogByYear(this.year).add(newItem);
//    }
}
