package com.esraa.dao;

import com.esraa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByCategoryName(String category);
    List<Product> findByBrand(String brand);
    List<Product> findByName(String name);
    List<Product> findByBrandAndName(String brand, String name);
    List<Product> findByBrandAndNameAndCategoryName(String brand, String name, String category);
    List<Product> findByCategoryNameAndBrand(String category, String brand);
    Long countByBrandAndName(String brand, String name);
}
