package me.dio.controller;

import me.dio.model.Product;
import me.dio.service.ProductService_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "products")
public class ProductController {

    @Autowired
    private ProductService_ productService;

    @GetMapping(path = "/{id}")
    public Product getFromWishList(@PathVariable Integer id){
        return productService.getFromWishList(id);

    }

    @PostMapping
    public Product addToWishList(@RequestBody Product product){
        Product savedProduct = productService.addToWishList(product);
        return savedProduct;
    }

    public ProductService_ getProductService() {
        return productService;
    }

    public void setProductService(ProductService_ productService) {
        this.productService = productService;
    }

    @PutMapping
    public Product updateWishList(@RequestBody Product product){
        Product updatedProduct = productService.updateWishList(product);
        return updatedProduct;
    }

    @DeleteMapping(path = "/{id}")
    public String deleteFromWishList(@PathVariable Integer id){
        return productService.deleteFromWishList(id);
    }
}
