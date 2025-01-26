package main.test.abstractFactory;

public class NextDayDeliveryPackingFactory implements DeliveryPackingFactory {
    @Override
    public Box createBox() {
        return new CardboardBox();
    }
}
