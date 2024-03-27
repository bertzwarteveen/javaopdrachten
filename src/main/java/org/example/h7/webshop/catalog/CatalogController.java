package org.example.h7.webshop.catalog;

import org.example.h7.webshop.item.Item;

import java.util.Optional;

public class CatalogController {
    CatalogRepo catalogRepo = new CatalogRepo();

    public Catalog getCatalogPicked() {
        return catalogPicked;
    }

    public void setCatalogPicked(Catalog catalogPicked) {
        this.catalogPicked = catalogPicked;
    }

    private Catalog catalogPicked;

    private Optional<Item> getItem(int itemId) {
        return catalogRepo.findItemBy(itemId, getCatalogPicked());
    }

}
