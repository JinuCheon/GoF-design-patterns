package main.test.abstractFactory;

public interface DeliveryPackingFactory {
    static DawanDeliveryPackingFactory forDawn() {
        return new DawanDeliveryPackingFactory();
    }

    static NextDayDeliveryPackingFactory forNextDay() {
        return new NextDayDeliveryPackingFactory();
    }

    Box createBox();

    Label createLabel();
}
