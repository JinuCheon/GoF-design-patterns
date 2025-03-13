package main.bridge;

class BasicCart implements Cart {
    private final double totalAmount;
    private final DiscountPolicy discountPolicy;

    public BasicCart(double totalAmount, DiscountPolicy discountPolicy) {
        this.totalAmount = totalAmount;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public double calculateTotal() {
        return discountPolicy.applyDiscount(totalAmount);
    }
}