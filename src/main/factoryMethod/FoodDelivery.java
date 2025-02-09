package main.factoryMethod;

import java.util.List;

public class FoodDelivery implements Delivery {

    private final List<Item> items;

    public FoodDelivery(final List<Item> items) {
        this.items = items;
    }

    public static Delivery from(final List<Item> foodItems) {
        return new FoodDelivery(foodItems);
    }

    @Override
    public Long itemQty() {
        return items.stream().mapToLong(Item::qty).sum();
    }
}
