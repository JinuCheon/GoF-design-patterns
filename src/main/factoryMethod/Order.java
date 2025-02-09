package main.factoryMethod;

public class Order {
    public static Order with(final OrderItem... foodItems) {
        throw new UnsupportedOperationException("Unsupported with");
    }
}
