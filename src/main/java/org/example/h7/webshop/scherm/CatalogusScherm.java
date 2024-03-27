package org.example.h7.webshop.scherm;

import org.example.h7.webshop.WebshopInterface;
import org.example.h7.webshop.catalog.Catalog;
import org.example.h7.webshop.catalog.CatalogController;
import org.example.h7.webshop.catalog.CatalogRepo;
import org.example.h7.webshop.item.Item;


import java.util.List;
import java.util.Optional;


public class CatalogusScherm {
    CatalogRepo catalogRepo = new CatalogRepo();
    CatalogController catalogController = new CatalogController();

    public void seeCatalogus() {
        List<Catalog> pickedCatalogList = askUserCatalogus();
        Catalog pickedCatalog = pickedCatalogList.getFirst();
        catalogController.setCatalogPicked(pickedCatalog);
        System.out.println(pickedCatalog.toString());
    }

    private List<Catalog> askUserCatalogus() {
        List<Integer> availableYears = catalogRepo.findAvailableYears();

        String pickedCatalog = WebshopInterface.promptUser(
                "Which catalog are you interested in viewing?\n" +
                        "We have catalogs for these years: " +
                        availableYears);
        try {
            return checkIfCatalogusAvailable(Integer.parseInt(pickedCatalog));
        } catch (NumberFormatException e) {
            System.out.println("Please enter a whole number.");
            return askUserCatalogus();
        }
    }

    private List<Catalog> checkIfCatalogusAvailable(int pickedCatalog) {
        List<Integer> availableYears = catalogRepo.findAvailableYears();
        if (availableYears.contains(pickedCatalog)) {
            return catalogRepo.findBy(pickedCatalog);
        } else {
            System.out.println("This year is not available, please enter an available catalogus.");
            return askUserCatalogus();
        }
    }
    public Optional<Item> getItem(int itemId) {
        return catalogRepo.findItemBy(itemId, catalogController.getCatalogPicked());
   };

}
