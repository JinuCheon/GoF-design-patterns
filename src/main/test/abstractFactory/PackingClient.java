package main.test.abstractFactory;

public class PackingClient {

    private final DeliveryPackingFactory deliveryPackingFactory;

    public PackingClient(final DeliveryPackingFactory deliveryPackingFactory) {
        this.deliveryPackingFactory = deliveryPackingFactory;
    }

    public String boxType() {
        final Box box = deliveryPackingFactory.createBox();
        return box.boxType();
    }
}
