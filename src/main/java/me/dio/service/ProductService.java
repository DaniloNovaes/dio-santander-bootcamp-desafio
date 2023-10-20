package me.dio.service;

import me.dio.model.Product;
import me.dio.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements ProductService_ {

    @Autowired //Para não precisar fazer o new()
   private ProductRepository productRepository;

   public ProductRepository getProductRepository() {
       return productRepository;
   }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addToWishList(Product product) {
       Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    @Override
    public Product getFromWishList(Integer id){
       Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);
    }

    @Override
    public Product updateWishList(Product product){
       Product productFromDb = productRepository.findById(product.getId()).orElse(null);
       if(productFromDb == null){
           throw new RuntimeException ("There is no such WishList");
       }
       productFromDb.setProductName(product.getProductName());
       productFromDb.setPrice(product.getPrice());
       productFromDb.setDate(product.getDate());
       productFromDb.setDesiredPrice(product.getDesiredPrice());
       productFromDb.setProductLink(product.getProductLink());
       return productRepository.save(productFromDb);
    }

    @Override
    public String deleteFromWishList(Integer id){
       productRepository.deleteById(id);
       return "Product deleted from wishlist";
    }
}
