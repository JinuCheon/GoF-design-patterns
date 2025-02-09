package main.factoryMethod;

import java.util.List;

public class MigrateDeliveryUseCase {
    public List<Delivery> migrateFoodDeliveries(final Order order) {
        final MigrationResult afterFoodMigrate = migrateFoodDeliveries(order.items());
        final MigrationResult afterElectronicsMigrate = migrateElectronicsDeliveries(afterFoodMigrate.remainedItems);
        final MigrationResult afterCommonMigrate = migrateOthers(afterElectronicsMigrate.remainedItems);

        return List.of(
                afterFoodMigrate.delivery(),
                afterElectronicsMigrate.delivery(),
                afterCommonMigrate.delivery()
        );
    }

    private MigrationResult migrateOthers(final List<Item> remainedItems) {
        return new MigrationResult(CommonDelivery.from(remainedItems), List.of());
    }

    private MigrationResult migrateElectronicsDeliveries(final List<Item> remainedItems) {
        final List<Item> electronicsItems = remainedItems.stream()
                .filter(Item::isElectronics)
                .toList();
        final List<Item> commonItems = remainedItems.stream()
                .filter(item -> !item.isElectronics())
                .toList();
        return new MigrationResult(ElectronicsDelivery.from(electronicsItems), commonItems);
    }

    private MigrationResult migrateFoodDeliveries(final List<Item> items) {
        final List<Item> foodItems = items.stream()
                .filter(Item::isFood)
                .toList();
        final List<Item> remainedItems = items.stream()
                .filter(item -> !item.isFood())
                .toList();
        return new MigrationResult(FoodDelivery.from(foodItems), remainedItems);
    }

    private record MigrationResult(Delivery delivery, List<Item> remainedItems) {
    }
}
