package edu.ali.product_api.services;

import edu.ali.product_api.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(String productId);
    Product addProduct(Product product);
    Product updateProduct(Product product);
    Product deleteProduct(String productId);
}
