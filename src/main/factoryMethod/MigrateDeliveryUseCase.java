package main.factoryMethod;

import java.util.List;

public class MigrateDeliveryUseCase {
    private final ElectronicDeliveryFactory electronicDeliveryFactory = new ElectronicDeliveryFactory();
    private final FoodDeliveryFactory foodDeliveryFactory = new FoodDeliveryFactory();
    private final CommonDeliveryFactory commonDeliveryFactory = new CommonDeliveryFactory();

    public List<Delivery> migrateFoodDeliveries(final Order order) {
        final MigrationResult afterFoodMigrate = foodDeliveryFactory.migrate(order.items());
        final MigrationResult afterElectronicsMigrate = electronicDeliveryFactory.migrate(afterFoodMigrate.remainedItems());
        final MigrationResult afterCommonMigrate = commonDeliveryFactory.migrate(afterElectronicsMigrate.remainedItems());

        return List.of(
                afterFoodMigrate.delivery(),
                afterElectronicsMigrate.delivery(),
                afterCommonMigrate.delivery()
        );
    }
}
