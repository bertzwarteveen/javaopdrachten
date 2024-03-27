package org.example.h7.webshop.scherm;

import org.example.h7.webshop.WebshopInterface;
import org.example.h7.webshop.customer.CustomerRepo;

public class InlogScherm {

    CustomerRepo customerRepo = new CustomerRepo();

    public void greetAndAddCustomer() {
        String customerName = promptUserName();
        String customerResidence = promptUserResidence();
        customerRepo.add(customerResidence, customerName);
        greetCustomer(customerName, customerResidence);
    }

    private void greetCustomer(String name, String residence) {
        System.out.println("Welcome to our shop " + name + "!" + " It's quite the journey from " + residence + ".");
    }

    private String promptUserName() {
        return WebshopInterface.promptUser("What is your name?");
    }

    private String promptUserResidence() {
        return WebshopInterface.promptUser("Where do you live?");
    }


}
