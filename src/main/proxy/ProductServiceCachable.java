package main.proxy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductServiceCachable implements ProductService {

    private final ProductService delegate;
    private final Map<Long, Product> cache = new ConcurrentHashMap<>();

    public ProductServiceCachable(final ProductService delegate) {this.delegate = delegate;}

    @Override
    public Product getProductById(final long productId) {
        return cache.computeIfAbsent(productId, delegate::getProductById);
    }
}
