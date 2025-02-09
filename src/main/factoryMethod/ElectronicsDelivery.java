package main.factoryMethod;

import java.util.List;

public class ElectronicsDelivery implements Delivery {

    private final List<Item> items;

    public ElectronicsDelivery(final List<Item> items) {
        this.items = items;
    }

    public static Delivery from(final List<Item> electronicsItems) {
        return new ElectronicsDelivery(electronicsItems);
    }

    @Override
    public Long itemQty() {
        return items.stream().mapToLong(Item::qty).sum();
    }
}
