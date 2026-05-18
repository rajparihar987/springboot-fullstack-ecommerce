package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    @NotBlank
    @Size(min = 3, message = "Product name must contain at least 3 characters")
    private String productName;
    private String productImage;
    @Size(min = 10, message = "Product description must contain at least 10 characters")
    private String description;
    private Integer quantity;
    private Double price; //100
    private Double discount; //25
    private Double specialPrice; //75

    @ManyToOne // Many Products can come under one category...
    @JoinColumn(name = "category_id")
    private Category category;
}
