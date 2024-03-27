package org.example.h7.webshop;

import org.example.h7.webshop.scherm.CatalogusScherm;
import org.example.h7.webshop.scherm.InlogScherm;
import org.example.h7.webshop.scherm.OrderScherm;

import java.util.Scanner;

public class WebshopInterface {

    InlogScherm inlogScherm = new InlogScherm();
    OrderScherm orderScherm = new OrderScherm();

    public void webshopStart() {
        inlogScherm.greetAndAddCustomer();
        orderScherm.greetAndGuideOrdering();
    }

    public static String promptUser(String prompt) {
        Scanner in = new Scanner(System.in);
        System.out.println(prompt);
        return in.nextLine();
    }
        // Toevoegen check y/n
    public static Boolean checkContinuance(String promptContinuance) {
        if (promptContinuance.equalsIgnoreCase("yes")) {
            return true;
        }
        if (promptContinuance.equalsIgnoreCase("no")) {
            return false;
        } else {
            System.out.println("Only yes or no please!");
            return checkContinuance(promptContinuance);
        }
    }

}
