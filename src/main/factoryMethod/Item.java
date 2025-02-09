package main.factoryMethod;

public class Item {

    private final int qty;
    private final ItemType type;

    private Item(final int qty, final ItemType type) {
        this.qty = qty;
        this.type = type;
    }

    public static Item createAsFoods(final int qty) {
        return new Item(qty, ItemType.FOOD);
    }

    public static Item createAsElectronics(final int qty) {
        return new Item(qty, ItemType.ELECTRONICS);
    }

    public static Item createAsLiving(final int qty) {
        return new Item(qty, ItemType.COMMON);
    }

    public ItemType type() {
        return type;
    }

    public int qty() {
        return qty;
    }

    public boolean isFood() {
        return ItemType.FOOD == type;
    }

    public boolean isElectronics() {
        return ItemType.ELECTRONICS == type;
    }

    public boolean isCommon() {
        return ItemType.COMMON == type;
    }

    public enum ItemType {
        FOOD, ELECTRONICS, COMMON
    }
}
