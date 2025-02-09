package main.factoryMethod;

import java.util.List;

record MigrationResult(Delivery delivery, List<Item> remainedItems) {
}
