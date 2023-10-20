package me.dio.service;

import me.dio.model.Product;

public interface ProductService_ {

    public Product addToWishList(Product product);

    Product getFromWishList(Integer id);

    Product updateWishList(Product product);

    String deleteFromWishList(Integer id);
}
