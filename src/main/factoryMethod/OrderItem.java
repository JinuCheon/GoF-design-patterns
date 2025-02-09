package main.factoryMethod;

public class OrderItem {
    public static OrderItem createAsFoods(final int qty) {
        throw new UnsupportedOperationException("Unsupported createAsFoods");
    }

    public static OrderItem createAsElectronics(final int qty) {
        throw new UnsupportedOperationException("Unsupported createAsElectronics");
    }

    public static OrderItem createAsLiving(final int qty) {
        throw new UnsupportedOperationException("Unsupported createAsLiving");
    }
}
