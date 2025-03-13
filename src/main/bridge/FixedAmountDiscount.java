package main.bridge;

class FixedAmountDiscount implements DiscountPolicy {
    private final double discountAmount;

    public FixedAmountDiscount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return Math.max(0, totalAmount - discountAmount);
    }
}