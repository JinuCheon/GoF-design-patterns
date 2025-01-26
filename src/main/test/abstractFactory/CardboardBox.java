package main.test.abstractFactory;

public class CardboardBox implements Box {
    @Override
    public String boxType() {
        return "Cardboard Box";
    }
}
