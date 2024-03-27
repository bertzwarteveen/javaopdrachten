package org.example.h7.webshop.customer;

public class Customer {
    private String Residence;
    private String Name;

    public String getResidence() {
        return Residence;
    }

    public String getName() {
        return Name;
    }

    public Customer(String residence, String name) {
        Residence = residence;
        Name = name;
    }


    public void orderItem(){

    }


    @Override
    public String toString() {
        return Name + " " + Residence + "\n";
    }

}
