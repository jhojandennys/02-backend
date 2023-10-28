package com.dennys.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name="product_category")
// @Data -- known bug
@Getter
@Setter
public class ProductCategory {

    @Id
    @GeneratedValue()
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;

    public ProductCategory(String categoryName, Set<Product> products) {
        this.categoryName = categoryName;
        this.products = products;
    }
    public ProductCategory(){

    }

}







