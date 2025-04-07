package com.esraa.service.product;

import com.esraa.exception.ProductNotFoundException;
import com.esraa.model.Product;

import java.util.List;

public interface IProductService {

    Product addProduct(Product product);
    Product getProduct(Long id) throws ProductNotFoundException;
    void updateProduct(Product product);
    void deleteProduct(Long id);

    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);
    List<Product> getProductsByBrandAndNameAndCategory(String brand, String name, String category);
    Long CountProductsByBrandAndName(String brand, String name);


}
