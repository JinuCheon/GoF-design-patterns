package main.bridge;

public class Client {
    public static void main(String[] args) {
        // 10% 정률 할인 적용된 기본 장바구니
        Cart cart1 = new BasicCart(100, new PercentageDiscount(10));
        System.out.println("BasicCart with 10% discount: $" + cart1.calculateTotal());

        // 20달러 정액 할인 적용된 프로모션 장바구니
        Cart cart2 = new PromotionCart(100, new FixedAmountDiscount(20));
        System.out.println("PromotionCart with $20 discount and extra 10% promo: $" + cart2.calculateTotal());
    }
}