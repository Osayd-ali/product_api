package edu.ali.product_api.controllers;

import edu.ali.product_api.entities.Product;
import edu.ali.product_api.exceptions.InvalidProductException;
import edu.ali.product_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        Product product = productService.getProductById(id);
        if(product == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        else {
            return product;
        }
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        if(addedProduct == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product already exists");
        }
        else {
            return addedProduct;
        }
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        if(updatedProduct == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        else {
            return updatedProduct;
        }
    }

    @DeleteMapping("/delete/{id}")
    public Product deleteProduct(@PathVariable String id) {
        Product deletedProduct = productService.deleteProduct(id);
        if(deletedProduct == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        else {
            return deletedProduct;
        }
    }

    @ExceptionHandler(InvalidProductException.class)
    public ResponseEntity<ErrorHolder> handleInvalidProductException(InvalidProductException ex) {
        ErrorHolder errorHolder = new ErrorHolder(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                "/api/products",
                ex.getClass().getName()
        );
        return new ResponseEntity<>(errorHolder, HttpStatus.BAD_REQUEST);
    }

}