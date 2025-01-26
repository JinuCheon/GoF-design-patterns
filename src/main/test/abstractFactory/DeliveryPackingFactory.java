package main.test.abstractFactory;

public interface DeliveryPackingFactory {
    static DawanDeliveryPackingFactory forDawn() {
        return new DawanDeliveryPackingFactory();
    }

    Box createBox();

    Label createLabel();
}
