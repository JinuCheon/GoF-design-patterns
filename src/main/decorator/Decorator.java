package main.decorator;

// 1. 기본 배송 인터페이스
interface Delivery {
    String getDescription();

    double getCost();
}

// 2. 기본 배송 클래스 (ConcreteComponent)
class BasicDelivery implements Delivery {
    @Override
    public String getDescription() {
        return "기본 배송";
    }

    @Override
    public double getCost() {
        return 5000; // 기본 배송비 5000원
    }
}

// 3. 데코레이터 추상 클래스
abstract class DeliveryDecorator implements Delivery {
    protected Delivery decoratedDelivery;

    protected DeliveryDecorator(Delivery delivery) {
        this.decoratedDelivery = delivery;
    }

    @Override
    public String getDescription() {
        return decoratedDelivery.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedDelivery.getCost();
    }
}

// 4. 빠른 배송 데코레이터
class ExpressDeliveryDecorator extends DeliveryDecorator {
    public ExpressDeliveryDecorator(Delivery delivery) {
        super(delivery);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + 빠른 배송";
    }

    @Override
    public double getCost() {
        return super.getCost() + 3000; // 추가 비용 3000원
    }
}

// 5. 취급주의(깨지기 쉬운 물품) 데코레이터
class FragileItemDecorator extends DeliveryDecorator {
    public FragileItemDecorator(Delivery delivery) {
        super(delivery);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + 취급주의";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2000; // 추가 비용 2000원
    }
}

// 6. 보험 추가 데코레이터
class InsuranceDecorator extends DeliveryDecorator {
    public InsuranceDecorator(Delivery delivery) {
        super(delivery);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + 보험 추가";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5000; // 추가 비용 5000원
    }
}

public class Decorator {
    public static void main(String[] args) {
        // 기본 배송
        Delivery basicDelivery = new BasicDelivery();
        System.out.println(basicDelivery.getDescription() + " - 비용: " + basicDelivery.getCost() + "원");

        // 빠른 배송 추가
        Delivery expressDelivery = new ExpressDeliveryDecorator(basicDelivery);
        System.out.println(expressDelivery.getDescription() + " - 비용: " + expressDelivery.getCost() + "원");

        // 빠른 배송 + 취급주의 추가
        Delivery fragileExpressDelivery = new FragileItemDecorator(expressDelivery);
        System.out.println(fragileExpressDelivery.getDescription() + " - 비용: " + fragileExpressDelivery.getCost() + "원");

        // 빠른 배송 + 취급주의 + 보험 추가
        Delivery insuredFragileExpressDelivery = new InsuranceDecorator(fragileExpressDelivery);
        System.out.println(insuredFragileExpressDelivery.getDescription() + " - 비용: " + insuredFragileExpressDelivery.getCost() + "원");
    }
}