package main.factoryMethod;

import java.util.List;

public class Order {

    private final List<Item> items;

    private Order(final List<Item> items) {
        this.items = items;
    }

    public static Order with(final List<Item> foodItems) {
        return new Order(foodItems);
    }

    public List<Item> items() {
        return items;
    }
}
