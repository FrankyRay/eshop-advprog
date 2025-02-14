package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Jupiter.api.Assertion.*;

public class ProductTest {
    Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setProductId("6a69eae3-672d-4e44-9e44-c0997665c699");
        product.setProductName("OIIA Cat");
        product.setProductQuantity(911);
    }

    @Test
    void testGetProductId() {
        assertEquals("6a69eae3-672d-4e44-9e44-c0997665c699", product.getProductId());
    }

    @Test
    void testGetProductName() {
        assertEquals("OIIA Cat", product.getProductName());
    }

    @Test
    void testGetProductQuantity() {
        assertEquals(911, product.getProductQuantity());
    }
}
