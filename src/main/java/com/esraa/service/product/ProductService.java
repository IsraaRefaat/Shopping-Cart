package com.esraa.service.product;

import com.esraa.dao.ProductRepo;
import com.esraa.exception.ProductNotFoundException;
import com.esraa.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product getProduct(Long id) throws ProductNotFoundException {
        return productRepo.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product not found!"));
    }

    @Override
    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.findById(id).ifPresentOrElse(productRepo::delete,
                ()-> new ProductNotFoundException("Product not found!"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepo.findByCategoryName(category);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productRepo.findByBrand(brand);
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
        return productRepo.findByCategoryNameAndBrand(category,brand);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {
        return productRepo.findByBrandAndName(brand,name);
    }

    @Override
    public List<Product> getProductsByBrandAndNameAndCategory(String brand, String name, String category) {
        return productRepo.findByBrandAndNameAndCategoryName(brand,name,category);
    }

    @Override
    public Long CountProductsByBrandAndName(String brand, String name) {
        return productRepo.count();
    }
}
