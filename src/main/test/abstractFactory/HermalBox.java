package main.test.abstractFactory;

public class HermalBox implements Box {
    @Override
    public BoxType boxType() {
        return BoxType.Hermal;
    }
}
