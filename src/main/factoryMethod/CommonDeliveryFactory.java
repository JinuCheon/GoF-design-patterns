package main.factoryMethod;

import java.util.List;

public class CommonDeliveryFactory {
    public CommonDeliveryFactory() {
    }

    MigrationResult migrate(final List<Item> remainedItems) {
        return new MigrationResult(CommonDelivery.from(remainedItems), List.of());
    }
}