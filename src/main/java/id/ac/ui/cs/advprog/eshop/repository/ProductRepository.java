package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product find(String productId) {
        for (Product product : productData) {
            if (product.getProductId().equals(productId))
                return product;
        }
        return null;
    }

    public Product update(String productId, Product product) {
        Product old = find(productId);
        old.setProductName(product.getProductName());
        old.setProductQuantity(product.getProductQuantity());
        return old;
    }

    public void delete(String productId) {
        Product old = find(productId);
        productData.remove(old);
    }
}
