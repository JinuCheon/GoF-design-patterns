package main.factoryMethod;

import java.util.List;

public class CommonDeliveryFactory implements DeliveryFactory {
    public CommonDeliveryFactory() {
    }

    public MigrationResult migrate(final List<Item> remainedItems) {
        return new MigrationResult(CommonDelivery.from(remainedItems), List.of());
    }
}