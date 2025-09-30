package edu.ali.product_api.services;

import edu.ali.product_api.dataholder.ProductData;
import edu.ali.product_api.entities.Product;
import edu.ali.product_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductData productData;
    @Value("${product.test.prefix}")
    private String testPrefix;

    @Autowired
    public ProductServiceImpl(ProductData productData) {
        this.productData = productData;
    }


    public List<Product> getAllProducts() {
        List<Product> products = productData.getAllProducts();
        List<Product> filteredProducts = new ArrayList<>(); // Creating a new list to keep track of filtered products which are not starting with testPrefix.
        for (Product product : products) {
            if(!(product.getProductId().startsWith(testPrefix))) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    @Override
    public Product getProductById(String id) {
        Product product = productData.getProductById(id);
        if(id.startsWith(testPrefix)) {
            return null;
        }
        else  {
            return product;
        }
    }

    @Override
    public Product addProduct(Product product) {
        if(productData.productExists(product.getProductId())) {
            return null;
        }
        else {
            return productData.addProduct(product);
        }
    }

    @Override
    public Product updateProduct(Product product) {
        if(!(productData.productExists(product.getProductId()))) {
            return null;
        }
        else {
            return productData.updateProduct(product);
        }
    }

    @Override
    public Product deleteProduct(String id) {
        if(!productData.productExists(id)) {
            return null;
        }
        else {
            return productData.deleteProduct(id);
        }
    }
}