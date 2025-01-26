package main.test.abstractFactory;

public class DawanDeliveryPackingFactory implements DeliveryPackingFactory {
    @Override
    public Box createBox() {
        return new HermalBox();
    }

    @Override
    public Label createLabel() {
        return new QuickDeliveryLabel();
    }
}
