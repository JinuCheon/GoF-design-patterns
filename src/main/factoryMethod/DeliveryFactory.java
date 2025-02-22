package main.factoryMethod;

import java.util.List;

public interface DeliveryFactory {

    MigrationResult migrate(final List<Item> items);
}
