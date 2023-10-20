package me.dio.model;

import jakarta.persistence.*;

@Entity(name = "wishlist-information")
public class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;
    private String productName;
    private Double price;

    private String date;

    private Double desiredPrice;

    @Column(columnDefinition = "TEXT")
    private String productLink;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getDesiredPrice() {
        return desiredPrice;
    }

    public void setDesiredPrice(Double desiredPrice) {
        this.desiredPrice = desiredPrice;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
