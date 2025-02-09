package main.factoryMethod;

import java.util.List;

public class Order {

    private final List<OrderItem> items;

    private Order(final List<OrderItem> items) {
        this.items = items;
    }

    public static Order with(final List<OrderItem> foodItems) {
        return new Order(foodItems);
    }
}
