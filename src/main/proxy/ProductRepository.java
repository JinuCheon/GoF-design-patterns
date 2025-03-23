package main.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductRepository {
    private final Map<Long, Product> storage = new HashMap<>();

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public void save(Product product) {
        storage.put(product.getId(), product);
    }
}