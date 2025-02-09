package main.factoryMethod;

import java.util.List;

public class FoodDeliveryFactory {
    public FoodDeliveryFactory() {
    }

    MigrationResult migrate(final List<Item> items) {
        final List<Item> foodItems = items.stream()
                .filter(Item::isFood)
                .toList();
        final List<Item> remainedItems = items.stream()
                .filter(item -> !item.isFood())
                .toList();
        return new MigrationResult(FoodDelivery.from(foodItems), remainedItems);
    }
}