package main.test.abstractFactory;

public class QuickDeliveryLabel implements Label {
    @Override
    public String content() {
        return "Quick Delivery Label";
    }
}
