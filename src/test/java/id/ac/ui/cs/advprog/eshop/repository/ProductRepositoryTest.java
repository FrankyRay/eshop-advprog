package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {}

    @Test
    void testCreateAndFindProduct() {
        Product product = new Product();
        product.setProductId("c4b3327b-2862-4996-9b52-3705685d6226");
        product.setProductName("Momoi");
        product.setProductQuantity(69);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product foundProduct = productIterator.next();
        assertEquals(product.getProductId(), foundProduct.getProductId());
        assertEquals(product.getProductName(), foundProduct.getProductName());
        assertEquals(product.getProductQuantity(), foundProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("e16630e0-5728-4fe3-aff1-a23453275edd");
        product1.setProductName("Uno");
        product1.setProductQuantity(1);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("467835b7-0753-4f85-9aff-bf00b9448728");
        product2.setProductName("Tres");
        product2.setProductQuantity(2);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product foundProduct = productIterator.next();
        assertEquals(product1.getProductId(), foundProduct.getProductId());

        foundProduct = productIterator.next();
        assertEquals(product2.getProductId(), foundProduct.getProductId());

        assertFalse(productIterator.hasNext());
    }
}
