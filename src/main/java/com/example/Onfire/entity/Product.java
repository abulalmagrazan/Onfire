package com.example.Onfire.entity;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Entity(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProduct")
    private Long idProduct;

    @Column(name = "IdCategory")
    private Long IdCategory;

    @Column(name = "Name")
    private String name;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCategory",insertable = false,updatable = false)
    public Category category;

    public Product(Long idProduct, Long idCategory, String name, Double price, String description) {
        this.idProduct = idProduct;
        IdCategory = idCategory;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
