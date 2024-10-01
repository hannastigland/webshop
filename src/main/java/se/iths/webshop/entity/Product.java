package se.iths.webshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private double price;
    private String description;
    private String category;
    private int stockQuantity;
    private String imageUrl;
    private double discountPrice;

    public Product() {
    }
}
