package main.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProductServiceTest {

    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
        productService = new ProductService(productRepository);

        productRepository.save(new Product(1L, "낚시대", 10000));
    }

    @Test
    void 상품ID로_상품을_조회할_수_있다() {
        // when
        Product product = productService.getProductById(1L);

        // then
        assertNotNull(product);
        assertEquals(1L, product.getId());
        assertEquals("낚시대", product.getName());
        assertEquals(10000, product.getPrice());
    }

}
