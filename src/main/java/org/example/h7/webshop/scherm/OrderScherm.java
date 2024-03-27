package org.example.h7.webshop.scherm;

import org.example.h7.webshop.Database;
import org.example.h7.webshop.WebshopInterface;
import org.example.h7.webshop.item.Item;
import org.example.h7.webshop.order.OrderRepo;

import java.math.BigDecimal;
import java.util.*;

public class OrderScherm {
    OrderRepo orderRepo = new OrderRepo();
    CatalogusScherm catalogusScherm = new CatalogusScherm();

    public void greetAndGuideOrdering() {
        Boolean keepCatalogus = true;
        Map<Item, Integer> itemsOrdered = new HashMap<>();
        BigDecimal priceOrder = BigDecimal.valueOf(0);

        while (Boolean.TRUE.equals(keepCatalogus)) {
            catalogusScherm.seeCatalogus();

            Boolean keepOrdering = true;

            while (Boolean.TRUE.equals(keepOrdering)) {
                BigDecimal subPriceOrder = BigDecimal.valueOf(0);

                Item orderedItem = promptItemId();
                if (orderedItem == null) {
                    promptItemId();
                }
                int quantityItem = promptItemAmount();

                subPriceOrder = subPriceOrder.add(addToOrder(orderedItem, quantityItem, itemsOrdered, subPriceOrder));
                priceOrder = priceOrder.add(subPriceOrder);

                keepOrdering = WebshopInterface.checkContinuance(promptContinuanceOrdering());
            }

            keepCatalogus = WebshopInterface.checkContinuance(promptContinuanceCatalog());

        }
        orderRepo.create(priceOrder, Database.customers.getFirst(), itemsOrdered);
        System.out.println(Database.orders.getLast().toString());

    }


    private BigDecimal addToOrder(Item item, int quantity, Map<Item, Integer>itemsOrdered, BigDecimal priceOrder) {
        for (int i = 0; i < quantity; i++) {
            itemsOrdered.put(item, itemsOrdered.getOrDefault(item, 0) + 1);
            priceOrder = priceOrder.add(item.getPrice());
        }
        return priceOrder;
    }

    private Item promptItemId() {
        String itemIdPicked = promptOrdering();
        try {
            int itemId = Integer.parseInt(itemIdPicked);
            return checkItemId(itemId);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a whole number.");
            return promptItemId();
        }
    }

    private int promptItemAmount() {
        String amountPicked = promptAmount();
        try {
            return Integer.parseInt(amountPicked);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a whole number.");
            return promptItemAmount();
        }
    }

    private Item checkItemId(int itemId) {
        Optional<Item> chosenItem = catalogusScherm.getItem(itemId);
        if (chosenItem.isPresent()) {
            return chosenItem.get();
        } else {
            int newItemId = Integer.parseInt(repromptOrdering());
            return checkItemId(newItemId);
        }
    }

    private String repromptOrdering() {
        return WebshopInterface.promptUser("Please select an item number that is available in this catalogus.");
    }

    private String promptOrdering() {
        return WebshopInterface.promptUser("Pick an item by number that you want to buy");
    }

    private String promptAmount() {
        return WebshopInterface.promptUser("How many do you want to order?");
    }

    private String promptContinuanceOrdering() {
        return WebshopInterface.promptUser("Do you want to continue ordering? (yes/no)");
    }

    private String promptContinuanceCatalog() {
        return WebshopInterface.promptUser("Do you want to view a different catalog? (yes/no)");
    }
}
