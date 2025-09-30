// This class is a data holder for our product objects
package edu.ali.product_api.dataholder;
import edu.ali.product_api.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ProductData {
    private final HashMap<String, Product> allProducts = new HashMap<>();
    public ProductData(){
        allProducts.put("WRM102", new Product("WRM102", "Wireless Mouse", 19.99));
        allProducts.put("BTH237", new Product("BTH237", "Bluetooth Headphones", 49.99));
        allProducts.put("USC514", new Product("USC514", "USB-C Charger", 14.25));
        allProducts.put("LDL783", new Product("LDL783", "LED Desk Lamp", 22.50));
        allProducts.put("NBK320", new Product("NBK320", "Notebook (5-Pack)", 7.99));
        allProducts.put("MKB901", new Product("MKB901", "Mechanical Keyboard", 89.00));
        allProducts.put("WRT655", new Product("WRT655", "Wireless Router", 64.99));
        allProducts.put("PPB876", new Product("PPB876", "Portable Power Bank", 29.95));
        allProducts.put("UFD112", new Product("UFD112", "16GB USB Flash Drive", 8.49));
        allProducts.put("AAA300", new Product("AAA300", "Webcam 1080p", 39.95));
        allProducts.put("SPS744", new Product("SPS744", "Smartphone Stand", 10.99));
        allProducts.put("EOC628", new Product("EOC628", "Ergonomic Office Chair", 129.99));
        allProducts.put("GMP433", new Product("GMP433", "Gaming Mouse Pad", 12.75));
        allProducts.put("HDC921", new Product("HDC921", "HDMI Cable (6ft)", 6.99));
        allProducts.put("LCP556", new Product("LCP556", "Laptop Cooling Pad", 25.99));
        allProducts.put("DAT611", new Product("DAT611", "Digital Alarm Clock", 18.49));
        allProducts.put("AAA879", new Product("AAA879", "Desk Organizer Tray", 13.95));
        allProducts.put("NCE384", new Product("NCE384", "Noise Cancelling Earbuds", 59.00));
        allProducts.put("SLB740", new Product("SLB740", "Smart LED Light Bulb", 11.99));
        allProducts.put("RWB205", new Product("RWB205", "Reusable Water Bottle", 17.50));
    }

    public List<Product> getAllProducts(){
        List<Product> productList = new ArrayList<>(allProducts.values());
        if(allProducts.isEmpty())
            return new ArrayList<>();
        else
            return productList;
    }

    public Product getProductById(String id){
        for (Product product : allProducts.values()){
            if(product.getProductId().equals(id)){
                return product;
            }
        }
        return null;
    }

    public Product addProduct(Product product){
        allProducts.put(product.getProductId(), product);
        return product;
    }

    public Product updateProduct(Product product){
        allProducts.put(product.getProductId(), product);
        return product;
    }

    public Product deleteProduct(String id){
        if(allProducts.containsKey(id)){
            return allProducts.remove(id);
        }
        return null;
    }

    public boolean productExists(String id){
        return allProducts.containsKey(id);
    }

    public int productCount(){
        return allProducts.size();
    }
}