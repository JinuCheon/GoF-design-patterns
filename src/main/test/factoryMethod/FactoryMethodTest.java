package main.test.factoryMethod;

import main.factoryMethod.Delivery;
import main.factoryMethod.ElectronicsDelivery;
import main.factoryMethod.FoodDelivery;
import main.factoryMethod.LivingDelivery;
import main.factoryMethod.MigrateDeliveryUseCase;
import main.factoryMethod.Order;
import main.factoryMethod.OrderItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FactoryMethodTest {

    @Test
    @DisplayName("커머스 주문을 받아서, 아이템 별로 배송을 나눠서 처리한다.")
    public void migrateOrderToDelivery() {
        MigrateDeliveryUseCase sut = new MigrateDeliveryUseCase();
        Order order = Order.with(
                createFoodItem(),
                createFoodItem(),
                createElectronicsItem(),
                createLivingItem()
        );

        List<Delivery> deliveries = sut.migrate(order);

        Assertions.assertEquals(2, countFoodDelivery(deliveries));
        Assertions.assertEquals(1, countElectronicsDelivery(deliveries));
        Assertions.assertEquals(1, countLivingDelivery(deliveries));
    }

    private Long countLivingDelivery(final List<Delivery> deliveries) {
        return deliveries.stream().filter(delivery -> delivery instanceof LivingDelivery).count();
    }

    private Long countElectronicsDelivery(final List<Delivery> deliveries) {
        return deliveries.stream().filter(delivery -> delivery instanceof ElectronicsDelivery).count();
    }

    private Long countFoodDelivery(final List<Delivery> deliveries) {
        return deliveries.stream().filter(delivery -> delivery instanceof FoodDelivery).count();
    }

    private OrderItem createLivingItem() {
        return OrderItem.createAsLiving(1);
    }

    private OrderItem createElectronicsItem() {
        return OrderItem.createAsElectronics(1);
    }

    private OrderItem createFoodItem() {
        return OrderItem.createAsFoods();
    }
}
