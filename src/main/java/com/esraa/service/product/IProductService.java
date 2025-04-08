package com.esraa.service.product;

import com.esraa.exception.ProductNotFoundException;
import com.esraa.model.Product;
import com.esraa.model.ProductDTO;

import java.util.List;

public interface IProductService {

    ProductDTO addProduct(ProductDTO product);
    ProductDTO updateProduct(Long productId, ProductDTO product);
    Product getProduct(Long id) throws ProductNotFoundException;
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
