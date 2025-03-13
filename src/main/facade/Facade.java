package main.facade;

public class Facade {

    // 운송장 발행
    class ShippingLabelGenerator {
        void generateLabel() {
            System.out.println("운송장 발행 완료.");
        }
    }

    // 포장
    class PackagingMachine {
        void pack() {
            System.out.println("포장 완료.");
        }
    }

    // Facade: 자동화 장비 (운송장 발행 + 포장을 한 번에 처리)
    class AutomatedLogisticsFacade {
        private final ShippingLabelGenerator labelGenerator;
        private final PackagingMachine packagingMachine;

        AutomatedLogisticsFacade() {
            this.labelGenerator = new ShippingLabelGenerator();
            this.packagingMachine = new PackagingMachine();
        }

        public void processShipmentAutomatically() {
            System.out.println("[자동화 장비 시작]");
            labelGenerator.generateLabel();
            packagingMachine.pack();
            System.out.println("[자동화 장비 완료]");
        }
    }

    public void main(String[] args) {
        AutomatedLogisticsFacade automatedFacade = new AutomatedLogisticsFacade();
        automatedFacade.processShipmentAutomatically();
    }
}
