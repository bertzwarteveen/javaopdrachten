package org.example.h7.webshop.catalog;

import org.example.h7.webshop.Database;
import org.example.h7.webshop.item.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CatalogRepoTest {
    @Mock
    private Database database;

    @InjectMocks
    private CatalogRepo sut;

    List<Catalog> catalogList = new ArrayList<>((Arrays.asList(
            new Catalog(2023, new ArrayList<>((Arrays.asList(
                    new Item(1, BigDecimal.valueOf(50), "Kaas", 2023),
                    new Item(2, BigDecimal.valueOf(10), "Brood", 2023),
                    new Item(3, BigDecimal.valueOf(3.5), "Melk", 2023))))),
            new Catalog(2024, new ArrayList<>((Arrays.asList(
                    new Item(11, BigDecimal.valueOf(55), "Chocolade", 2024),
                    new Item(12, BigDecimal.valueOf(8), "Broccoli", 2024),
                    new Item(13, BigDecimal.valueOf(4), "Yoghurt", 2024))))))
    ));


    @Test
    void findACatalogByFillingInTheYearOfTheCatalog() {
        // given the database

        Catalog foundOutcome = sut.findBy(2023).getFirst();

        Catalog expectedOutcome = Database.catalogs.getFirst();
        assertEquals(foundOutcome, expectedOutcome);
    }

    @Test
    void findItemBy() {
        Catalog desiredCatalog = catalogList.getFirst();

        Item foundOutcome = sut.findItemBy(2, desiredCatalog).get();

        Item expectedOutcome = Database.catalogs.getFirst().getItems().get(1);
        assertEquals(foundOutcome, expectedOutcome);
    }

}