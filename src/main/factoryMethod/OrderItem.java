package main.factoryMethod;

public class OrderItem {

    private final int qty;
    private final OrderItemType type;

    private OrderItem(final int qty, final OrderItemType type) {
        this.qty = qty;
        this.type = type;
    }

    public static OrderItem createAsFoods(final int qty) {
        return new OrderItem(qty, OrderItemType.FOOD);
    }

    public static OrderItem createAsElectronics(final int qty) {
        return new OrderItem(qty, OrderItemType.ELECTRONICS);
    }

    public static OrderItem createAsLiving(final int qty) {
        return new OrderItem(qty, OrderItemType.LIVING);
    }

    public enum OrderItemType {
        FOOD, ELECTRONICS, LIVING
    }
}
