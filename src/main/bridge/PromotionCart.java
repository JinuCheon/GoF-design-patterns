package main.bridge;

class PromotionCart implements Cart {
    private final double totalAmount;
    private final DiscountPolicy discountPolicy;

    public PromotionCart(double totalAmount, DiscountPolicy discountPolicy) {
        this.totalAmount = totalAmount;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public double calculateTotal() {
        double discountedPrice = discountPolicy.applyDiscount(totalAmount);
        return discountedPrice * 0.9; // 추가 프로모션 적용 (예: 10% 추가 할인)
    }
}