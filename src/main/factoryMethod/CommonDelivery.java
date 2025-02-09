package main.factoryMethod;

import java.util.List;

public class CommonDelivery implements Delivery {

    private final List<Item> items;

    public CommonDelivery(final List<Item> items) {
        this.items = items;
    }

    public static Delivery from(final List<Item> commonItems) {
        return new CommonDelivery(commonItems);
    }

    @Override
    public Long itemQty() {
        return items.stream().mapToLong(Item::qty).sum();
    }
}
