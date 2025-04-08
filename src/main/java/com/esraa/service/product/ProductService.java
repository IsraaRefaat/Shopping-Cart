package com.esraa.service.product;

import com.esraa.dao.CategoryRepo;
import com.esraa.dao.ProductRepo;
import com.esraa.exception.ProductNotFoundException;
import com.esraa.model.Category;
import com.esraa.model.Product;
import com.esraa.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {

        Product product= createProduct(productDTO);

        //check if the category exist in db
        Category category = Optional.ofNullable(categoryRepo.findByName(productDTO.getCategory().getName()))
                .orElseGet(
                        ()->
                        {
                            Category newCategory = new Category(productDTO.getCategory().getName());
                            return categoryRepo.save(newCategory);
                        }
                );

        product.setCategory(category);
        productRepo.save(product);

        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {

        //Check if the product exists in db
        Product product = Optional.ofNullable(productRepo.findById(productId))
                .orElseGet(
                        ()->{
                            Product newProduct = createProduct(productDTO);
                            newProduct.setCategory(productDTO.getCategory());
                            return productRepo.save(newProduct);
                        }

                );

    }

    private Product createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setBrand(productDTO.getBrand());
        product.setImages(productDTO.getImages());
        product.setQuantity(productDTO.getQuantity());

        return product;
    }

    @Override
    public Product getProduct(Long id) throws ProductNotFoundException {
        return productRepo.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product not found!"));
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
        return productRepo.countByBrandAndName(brand,name);
    }
}
