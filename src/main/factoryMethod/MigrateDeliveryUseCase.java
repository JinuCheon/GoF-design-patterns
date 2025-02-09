package main.factoryMethod;

import java.util.List;

public class MigrateDeliveryUseCase {
    private final ElectronicDeliveryFactory electronicDeliveryFactory = new ElectronicDeliveryFactory();
    private final FoodDeliveryFactory foodDeliveryFactory = new FoodDeliveryFactory();
    private final CommonDeliveryFactory commonDeliveryFactory = new CommonDeliveryFactory();

    public List<Delivery> migrateFoodDeliveries(final Order order) {
        final MigrationResult afterFoodMigration = foodDeliveryFactory.migrate(order.items());
        final MigrationResult afterElectronicsMigration = electronicDeliveryFactory.migrate(afterFoodMigration.remainedItems());
        final MigrationResult afterCommonMigration = commonDeliveryFactory.migrate(afterElectronicsMigration.remainedItems());

        return List.of(
                afterFoodMigration.delivery(),
                afterElectronicsMigration.delivery(),
                afterCommonMigration.delivery()
        );
    }
}
