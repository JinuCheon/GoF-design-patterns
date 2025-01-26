package main.test.abstractFactory;

public class PackingClient {
    public PackingClient(final DawanDeliveryPackingFactory dawanDeliveryPackingFactory) {}

    public String boxType() {
        return "Hermal Box";
    }
}
