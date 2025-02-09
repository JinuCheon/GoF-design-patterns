package main.test.factoryMethod;

import main.factoryMethod.Delivery;
import main.factoryMethod.ElectronicsDelivery;
import main.factoryMethod.FoodDelivery;
import main.factoryMethod.CommonDelivery;
import main.factoryMethod.MigrateDeliveryUseCase;
import main.factoryMethod.Order;
import main.factoryMethod.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FactoryMethodTest {

    @Test
    @DisplayName("커머스 주문을 받아서, 아이템 별로 배송을 나눠서 처리한다.")
    public void migrateOrderToDelivery() {
        MigrateDeliveryUseCase sut = new MigrateDeliveryUseCase();
        Order order = Order.with(List.of(
                createFoodItem(),
                createFoodItem(),
                createElectronicsItem(),
                createLivingItem()
        ));

        List<Delivery> deliveries = sut.migrateFoodDeliveries(order);

        Assertions.assertEquals(2, countFoodDeliveryItems(deliveries));
        Assertions.assertEquals(1, countElectronicsDeliveryItems(deliveries));
        Assertions.assertEquals(1, countLivingDeliveryItems(deliveries));
    }

    private Long countLivingDeliveryItems(final List<Delivery> deliveries) {
        return deliveries.stream()
                .filter(delivery -> delivery instanceof CommonDelivery)
                .map(Delivery::itemQty)
                .reduce(0L, Long::sum);

    }

    private Long countElectronicsDeliveryItems(final List<Delivery> deliveries) {
        return deliveries.stream()
                .filter(delivery -> delivery instanceof ElectronicsDelivery)
                .map(Delivery::itemQty)
                .reduce(0L, Long::sum);
    }

    private Long countFoodDeliveryItems(final List<Delivery> deliveries) {
        return deliveries.stream()
                .filter(delivery -> delivery instanceof FoodDelivery)
                .map(Delivery::itemQty)
                .reduce(0L, Long::sum);
    }

    private Item createLivingItem() {
        return Item.createAsLiving(1);
    }

    private Item createElectronicsItem() {
        return Item.createAsElectronics(1);
    }

    private Item createFoodItem() {
        return Item.createAsFoods(1);
    }
}
