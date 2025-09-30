package edu.ali.product_api.entities;

import edu.ali.product_api.exceptions.InvalidProductException;

public class Product {
    private String productId;
    private String productName;
    private double productCost;

    public Product(){

    }
    public Product(String productId, String productName, double productCost) {
        setProductId(productId);
        setProductName(productName);
        setProductCost(productCost);
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        if(productId == null || productId.length() != 6){
            throw new InvalidProductException("Product ID cannot be null and must be 6 characters long");
        }
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        if(productName == null || productName.isEmpty()){
            throw new InvalidProductException("Product name cannot be null or empty");
        }
        this.productName = productName;
    }
    public double getProductCost() {
        return productCost;
    }
    public void setProductCost(double productCost) {
        if(productCost <= 0){
            throw new InvalidProductException("Product cost must be greater than zero");
        }
        this.productCost = productCost;
    }
}