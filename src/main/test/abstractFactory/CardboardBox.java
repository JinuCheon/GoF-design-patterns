package main.test.abstractFactory;

public class CardboardBox implements Box {
    @Override
    public BoxType boxType() {
        return BoxType.Cardboard;
    }
}
