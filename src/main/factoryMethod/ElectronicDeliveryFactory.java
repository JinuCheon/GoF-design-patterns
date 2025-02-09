package main.factoryMethod;

import java.util.List;

public class ElectronicDeliveryFactory {
    public ElectronicDeliveryFactory() {
    }

    public MigrationResult migrate(final List<Item> remainedItems) {
        final List<Item> electronicsItems = remainedItems.stream()
                .filter(Item::isElectronics)
                .toList();
        final List<Item> commonItems = remainedItems.stream()
                .filter(item -> !item.isElectronics())
                .toList();
        return new MigrationResult(ElectronicsDelivery.from(electronicsItems), commonItems);
    }
}