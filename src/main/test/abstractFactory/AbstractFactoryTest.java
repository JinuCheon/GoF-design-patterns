package main.test.abstractFactory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// - [v] 새벽배송은 보온 박스에 포장된다
/// - [v] 다음날배송은 골판지 박스에 포장된다
/// - [] 새벽배송은 "Dawn Delivery" 라는 라벨이 출력된다
/// - [] 다음날배송은 "Next Day Delivery" 라는 라벨이 출력된다
public class AbstractFactoryTest {

    @Test
    @DisplayName("새벽배송은 보온 박스에 포장되며, 다음날 배송은 골판지 박스에 포장된다")
    void dawn_delivery_should_be_packaged_in_hermal_box() {
        PackingClient dawnDeliveryPackingClient = new PackingClient(new DawanDeliveryPackingFactory());
        PackingClient nextDayDeliveryPackingClient = new PackingClient(new NextDayDeliveryPackingFactory());

        assertEquals(dawnDeliveryPackingClient.boxType(), "Hermal Box");
        assertEquals(nextDayDeliveryPackingClient.boxType(), "Cardboard Box");
    }
}
