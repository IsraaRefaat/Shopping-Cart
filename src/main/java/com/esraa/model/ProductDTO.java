package com.esraa.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDTO {

    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private int quantity;
    private Category category;
    private List<Image> images;

}
