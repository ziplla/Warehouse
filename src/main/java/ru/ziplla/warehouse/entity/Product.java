package ru.ziplla.warehouse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @NotBlank(message = "Name is required")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Article is required")
    @Column(name = "article", unique = true, nullable = false)
    private String article;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price must be positive or zero")
    @Column(name = "price")
    private Double price;

    @PositiveOrZero(message = "Quantity must be positive or zero")
    @Column(name = "quantity")
    private Long quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_quantity_change", nullable = false)
    private Date lastQuantityChange;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;
}
