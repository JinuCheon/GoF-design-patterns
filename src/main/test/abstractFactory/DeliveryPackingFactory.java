package main.test.abstractFactory;

public interface DeliveryPackingFactory {
    Box createBox();

    Label createLabel();
}
